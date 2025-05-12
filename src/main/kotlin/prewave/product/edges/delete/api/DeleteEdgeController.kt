package prewave.product.edges.delete.api

import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import prewave.product.edges.delete.api.model.DeleteEdgeReqModel

@RestController
class DeleteEdgeController(private val deleteEdgeService: DeleteEdgeService) {

    @DeleteMapping("/edges")
    fun deleteEdge(@RequestBody @Valid deleteEdgeReqModel: DeleteEdgeReqModel): ResponseEntity<String> {
        deleteEdgeService.deleteEdge(deleteEdgeReqModel)
        return ResponseEntity.ok("Edge deleted successfully")
    }
}