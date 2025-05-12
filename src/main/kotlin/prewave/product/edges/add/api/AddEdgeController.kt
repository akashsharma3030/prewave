package prewave.product.edges.add.api

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import prewave.product.common.EdgeResModel
import prewave.product.common.InvalidNodeDataException
import prewave.product.edges.add.api.model.AddEdgeRequestModel

@RestController
@RequestMapping("/edges")
class AddEdgeController(private val addEdgeService: AddEdgeService) {

    @Operation(summary = "Add an edge", description = "Adds an edge between two nodes in the tree")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Edge added successfully"),
            ApiResponse(responseCode = "400", description = "Invalid input", content = [Content()]),
            ApiResponse(responseCode = "500", description = "Internal server error", content = [Content()])
        ]
    )
    @PostMapping("/add")
    @Throws(InvalidNodeDataException::class)
    fun addEdge(@Valid model: AddEdgeRequestModel): EdgeResModel {
        return addEdgeService.addEdge(model)
    }

}