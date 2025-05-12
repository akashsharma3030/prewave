package prewave.product.edges.delete.api

import prewave.product.edges.delete.api.model.DeleteEdgeReqModel

interface DeleteEdgeService {
    fun deleteEdge(deleteEdgeReqModel: DeleteEdgeReqModel): Boolean
}