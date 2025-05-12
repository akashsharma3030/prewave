package prewave.product.edges.delete.api.model

import jakarta.validation.constraints.Positive

data class DeleteEdgeReqModel(
    @field:Positive(message = "FromNodeId must be a positive integer")
    val fromNodeId: Integer,

    @field:Positive(message = "ToNodeId must be a positive integer")
    val toNodeId: Integer
)