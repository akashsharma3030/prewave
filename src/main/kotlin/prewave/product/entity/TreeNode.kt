package prewave.product.entity

import java.time.Instant

data class TreeNode(
    val fromId: String,
    val toNodeIdString: List<String>,
    val isRootNode: Boolean,
    val timestamp: Instant = Instant.now()
)