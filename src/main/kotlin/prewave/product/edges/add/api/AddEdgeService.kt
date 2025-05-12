package prewave.product.edges.add.api

import prewave.product.common.EdgeResModel
import prewave.product.edges.add.api.model.AddEdgeRequestModel

interface AddEdgeService {

    fun addEdge(model: AddEdgeRequestModel): EdgeResModel
}