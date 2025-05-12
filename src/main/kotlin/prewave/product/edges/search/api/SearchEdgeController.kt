package prewave.product.edges.search.api

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import prewave.product.edges.search.api.model.Node
import prewave.product.common.ErrorResponse
import prewave.product.common.InvalidNodeDataException
import jakarta.validation.constraints.Positive

@RestController
class SearchEdgeController(private val searchEdgeService: SearchEdgeService) {

    @Operation(summary = "Search a node by nodeId")
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200",
                description = "Node found",
                content = [Content(
                    mediaType = "application/json",
                    schema = Schema(implementation = Node::class)
                )]
            ),
            ApiResponse(
                responseCode = "404",
                description = "Node not found",
                content = [Content(
                    mediaType = "application/json",
                    schema = Schema(implementation = ErrorResponse::class)
                )]
            ),
            ApiResponse(
                responseCode = "500",
                description = "Internal server error",
                content = [Content(
                    mediaType = "application/json",
                    schema = Schema(implementation = ErrorResponse::class)
                )]
            )
        ]
    )
    @GetMapping("/nodes/{nodeId}")
    fun searchNodeById(@PathVariable @Positive(message = "NodeId must be a positive integer") nodeId: Integer): ResponseEntity<Node> {
        val node = searchEdgeService.findNodeById(nodeId)
        return ResponseEntity.ok(node)
    }

}