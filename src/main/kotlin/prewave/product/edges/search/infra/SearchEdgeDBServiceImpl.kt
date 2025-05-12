package prewave.product.edges.search.infra

import org.jooq.DSLContext
import org.springframework.stereotype.Service
import prewave.product.common.InvalidNodeDataException
import prewave.product.edges.search.service.NodeResDto
import prewave.product.edges.search.service.SearchEdgeDBService

@Service
class SearchEdgeDBServiceImpl(
    private val dsl: DSLContext
) : SearchEdgeDBService {

    companion object {
        private const val RECURSIVE_QUERY = """
    WITH RECURSIVE node_tree AS (
        SELECT from_node_id, to_node_id
        FROM "Node"
        WHERE from_node_id = CAST(? AS INTEGER) OR to_node_id = CAST(? AS INTEGER)
        UNION ALL
        SELECT n.from_node_id, n.to_node_id
        FROM "Node" n
        INNER JOIN node_tree nt ON n.to_node_id = nt.from_node_id
    )
    SELECT * FROM node_tree
"""
    }

    override fun findNodeById(nodeId: Integer): NodeResDto {
        // Execute the recursive query
        val result = dsl.resultQuery(RECURSIVE_QUERY, nodeId.toString(), nodeId.toString()).fetch()

        if (result.isEmpty()) {
            throw InvalidNodeDataException("No data found for nodeId: $nodeId")
        }

        // Group results by from_node_id, preserving duplicates
        val nodeMap = result.groupBy(
            { it.getValue("from_node_id").toString() },
            { it.getValue("to_node_id").toString() }
        )

        // Build the tree structure
        return buildTree(nodeId.toString(), nodeMap)
    }

    private fun buildTree(currentNodeId: String, nodeMap: Map<String, List<String>>): NodeResDto {
        val children = nodeMap[currentNodeId]?.distinct()?.map { childId ->
            buildTree(childId, nodeMap)
        } ?: emptyList()

        return NodeResDto(
            nodeId = currentNodeId.toInt() as java.lang.Integer,
            children = if (children.isNotEmpty()) children else null
        )
    }
}