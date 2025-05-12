package prewave.product.edges.add.infra

import org.springframework.stereotype.Service
import prewave.product.edges.add.service.AddEdgeDBService
import prewave.product.edges.add.service.dto.AddEdgeReqDto
import prewave.product.jooq.tables.Node
import org.jooq.DSLContext
import org.jooq.impl.DSL
import prewave.product.common.InvalidNodeDataException

@Service
class AddEdgeDBServiceImpl(
    private val dsl: DSLContext
) : AddEdgeDBService {

    override fun addEdge(addEdgeReqDto: AddEdgeReqDto): Boolean {
        // Validate to prevent recursive nodes
        validateNoRecursiveEdge(addEdgeReqDto.fromNodeId.toInt(), addEdgeReqDto.toNodeId.toInt())

        // Insert the edge
        dsl.insertInto(Node.NODE)
            .columns(Node.NODE.FROM_NODE_ID, Node.NODE.TO_NODE_ID)
            .values(
                DSL.inline(addEdgeReqDto.fromNodeId.toInt()),
                DSL.inline(addEdgeReqDto.toNodeId.toInt())
            )
            .execute()

        return true
    }
    @Throws(InvalidNodeDataException::class)
    private fun validateNoRecursiveEdge(fromNodeId: Int, toNodeId: Int) {
        val recursiveQuery = """
        WITH RECURSIVE parent_nodes AS (
            SELECT to_node_id
            FROM "Node"
            WHERE from_node_id = CAST(? AS INTEGER)
            UNION ALL
            SELECT n.to_node_id
            FROM "Node" n
            INNER JOIN parent_nodes pn ON n.from_node_id = pn.to_node_id
        )
        SELECT 1 FROM parent_nodes
        WHERE to_node_id = CAST(? AS INTEGER)
    """

        val result = dsl.fetch(recursiveQuery, toNodeId, fromNodeId)

        if (result.isNotEmpty) {
            throw InvalidNodeDataException("Adding a recursive edge is not allowed: Node $fromNodeId already exists in the hierarchy of Node $toNodeId.")
        }
    }
}