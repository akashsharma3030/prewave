package prewave.product

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["prewave.product", "prewave.product.common"])
class ProductTreeApplication

fun main(args: Array<String>) {
	runApplication<ProductTreeApplication>(*args)
}
