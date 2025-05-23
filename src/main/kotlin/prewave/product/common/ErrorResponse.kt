package prewave.product.common

import java.time.LocalDateTime

data class ErrorResponse(
    val timestamp: LocalDateTime,
    val message: String,
    val status: Int
)
