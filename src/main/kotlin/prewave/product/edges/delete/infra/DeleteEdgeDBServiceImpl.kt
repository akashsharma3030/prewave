package prewave.product.edges.delete.infra

import org.jooq.DSLContext
import org.springframework.stereotype.Service
import prewave.product.common.InvalidNodeDataException
import prewave.product.edges.delete.service.DeleteEdgeDBService
import prewave.product.jooq.tables.Node

@Service
class DeleteEdgeDBServiceImpl(private val dsl: DSLContext) : DeleteEdgeDBService {

    override fun deleteEdge(fromNodeId: Integer, toNodeId: Integer): Boolean {
        val fromNodeExists = dsl.fetchExists(
            dsl.selectFrom(Node.NODE).where(Node.NODE.FROM_NODE_ID.eq(fromNodeId.toInt()))
        )
        val toNodeExists = dsl.fetchExists(
            dsl.selectFrom(Node.NODE).where(Node.NODE.TO_NODE_ID.eq(toNodeId.toInt()))
        )

        if (!fromNodeExists) {
            throw InvalidNodeDataException("fromNodeId does not exist")
        }

        if (!toNodeExists) {
            throw InvalidNodeDataException("toNodeId does not exist")
        }

        val rowsDeleted = dsl.deleteFrom(Node.NODE)
            .where(Node.NODE.FROM_NODE_ID.eq(fromNodeId.toInt()))
            .and(Node.NODE.TO_NODE_ID.eq(toNodeId.toInt()))
            .execute()

        return rowsDeleted > 0
    }
}