package prewave.product.edges.search.api

import prewave.product.edges.search.api.model.Node

interface SearchEdgeService {
    fun findNodeById(nodeId: Integer): Node
}