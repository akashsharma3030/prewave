package prewave.product.edges.search.api.model

data class Node(
    val nodeId: Integer,
    val children : List<Node>
)