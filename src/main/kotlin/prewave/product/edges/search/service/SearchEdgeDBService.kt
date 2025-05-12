package prewave.product.edges.search.service

interface SearchEdgeDBService {
    fun findNodeById(nodeId: Integer):NodeResDto

}