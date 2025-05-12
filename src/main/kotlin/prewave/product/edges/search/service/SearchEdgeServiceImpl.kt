package prewave.product.edges.search.service

import org.springframework.stereotype.Service
import prewave.product.edges.search.api.SearchEdgeService
import prewave.product.edges.search.api.model.Node

@Service
class SearchEdgeServiceImpl(
    private val searchEdgeDBService: SearchEdgeDBService
) : SearchEdgeService {

    override fun findNodeById(nodeId: Integer): Node {
        val searchNodeResDto = searchEdgeDBService.findNodeById(nodeId)

        fun mapToNode(nodeResDto: NodeResDto): Node {
            return Node(
                nodeId = nodeResDto.nodeId,
                children = nodeResDto.children?.map { childDto -> mapToNode(childDto) } ?: emptyList()
            )
        }
        return mapToNode(searchNodeResDto)
    }
}