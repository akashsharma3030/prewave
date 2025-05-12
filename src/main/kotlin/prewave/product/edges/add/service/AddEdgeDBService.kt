package prewave.product.edges.add.service

import prewave.product.edges.add.service.dto.AddEdgeReqDto

interface AddEdgeDBService {
    fun addEdge(addEdgeReqDto: AddEdgeReqDto): Boolean
}