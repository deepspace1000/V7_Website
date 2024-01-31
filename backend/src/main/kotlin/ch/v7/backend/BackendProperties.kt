package ch.v7.backend

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.NestedConfigurationProperty
import org.springframework.boot.context.properties.bind.ConstructorBinding

@ConfigurationProperties(prefix = "v7")
data class BackendProperties @ConstructorBinding constructor(
    @NestedConfigurationProperty
    val test: TestProperties,
    @NestedConfigurationProperty
    val jwt: JwtProperties,
)

data class TestProperties(
    val test: String?,
)

data class JwtProperties(
    val expirationInHours: Long,
    val key: String,
)
