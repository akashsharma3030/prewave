package prewave.product.edges.add.service

import org.springframework.stereotype.Service
import prewave.product.common.EdgeResModel
import prewave.product.edges.add.api.AddEdgeService
import prewave.product.edges.add.api.model.AddEdgeRequestModel
import prewave.product.edges.add.service.dto.AddEdgeReqDto

@Service
class AddEdgeServiceImpl(
    private val addEdgeDBService: AddEdgeDBService
) : AddEdgeService {

    override fun addEdge(model: AddEdgeRequestModel): EdgeResModel {
        val dto = AddEdgeReqDto(
            fromNodeId = model.fromNodeId,
            toNodeId = model.toNodeId
        )

        val success = addEdgeDBService.addEdge(dto)
        return EdgeResModel(
            message = if (success) "Edge added successfully" else "Failed to add edge"
        )
    }
}