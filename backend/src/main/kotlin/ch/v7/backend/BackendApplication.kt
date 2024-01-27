package ch.v7.backend

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info
import io.swagger.v3.oas.annotations.servers.Server
import org.springframework.boot.SpringBootConfiguration
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity

@SpringBootConfiguration
@EnableAutoConfiguration
@EnableScheduling
@EnableMethodSecurity
@EnableConfigurationProperties(value = [BackendProperties::class])
@OpenAPIDefinition(servers = [Server(url = "/api")], info = Info(title = "V7 API", version = "v0"))
class BackendApplication

fun main(args: Array<String>) {
    runApplication<BackendApplication>(args = args) {
        beans.forEach(::addInitializers)
    }
}
