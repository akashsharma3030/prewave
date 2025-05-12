package prewave.product.edges.search.service

data class NodeResDto(
   var nodeId: Integer,
   var children: List<NodeResDto>? = null,
)
