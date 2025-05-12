package prewave.product.edges.add.api.model

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Positive

data class AddEdgeRequestModel(

    @field:Positive(message = "FromNodeId must be a positive integer")
    @JsonProperty("fromNodeId")
    val fromNodeId: Integer,

    @field:Positive(message = "ToNodeId must be a positive integer")
    @JsonProperty("toNodeId")
    val toNodeId: Integer
)