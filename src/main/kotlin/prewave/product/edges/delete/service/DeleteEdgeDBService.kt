package prewave.product.edges.delete.service

interface DeleteEdgeDBService {

    fun deleteEdge(fromNodeId: Integer, toNodeId: Integer): Boolean

}