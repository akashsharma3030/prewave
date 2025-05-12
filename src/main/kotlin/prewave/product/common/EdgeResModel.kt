package prewave.product.common

import java.time.Instant

data class EdgeResModel(
    val timestamp: Instant = Instant.now(),
    val message: String
)