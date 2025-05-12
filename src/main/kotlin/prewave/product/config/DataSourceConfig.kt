package prewave.product.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource
import org.springframework.boot.jdbc.DataSourceBuilder

@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
class DataSourceConfig {

    lateinit var url: String
    lateinit var username: String
    lateinit var password: String
    lateinit var driverClassName: String

    @Bean
    fun dataSource(): DataSource {
        return DataSourceBuilder.create()
            .url(url)
            .username(username)
            .password(password)
            .driverClassName(driverClassName)
            .build()
    }
}