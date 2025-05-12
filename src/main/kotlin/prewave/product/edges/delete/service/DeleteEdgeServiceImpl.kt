package prewave.product.edges.delete.service

import org.springframework.stereotype.Service
import prewave.product.edges.delete.api.DeleteEdgeService
import prewave.product.edges.delete.api.model.DeleteEdgeReqModel

@Service
class DeleteEdgeServiceImpl(private val deleteEdgeDBService: DeleteEdgeDBService) : DeleteEdgeService {

    override fun deleteEdge(deleteEdgeReqModel: DeleteEdgeReqModel): Boolean {
        return deleteEdgeDBService.deleteEdge(
            fromNodeId = deleteEdgeReqModel.fromNodeId,
            toNodeId = deleteEdgeReqModel.toNodeId
        )
    }
}