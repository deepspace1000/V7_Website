package ch.v7.backend

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.NestedConfigurationProperty
import org.springframework.boot.context.properties.bind.ConstructorBinding

@ConfigurationProperties(prefix = "v7")
data class BackendProperties @ConstructorBinding constructor(
    @NestedConfigurationProperty
    val test: TestProperties,
)

data class TestProperties(
    val test: String,
)
