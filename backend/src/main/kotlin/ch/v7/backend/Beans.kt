package ch.v7.backend

import ch.v7.backend.ressort.ressortBeans
import ch.v7.backend.role.roleBeans
import ch.v7.backend.security.securityBeans
import ch.v7.backend.userressort.userRessortBeans
import ch.v7.backend.userrole.userRoleBeans
import ch.v7.backend.users.userBeans
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.media.Schema
import org.springdoc.core.customizers.OpenApiCustomizer
import org.springframework.context.support.beans

private val libraryBeans = beans {
    bean {
        OpenApiCustomizer { openApi: OpenAPI ->
            // Mark nullable types as such in the OpenAPI spec to improve the generated TypeScript types
            openApi.components.schemas.values
                .filter { schema: Schema<*> -> schema.type == "object" }
                .forEach { schema: Schema<*> ->
                    if (schema.properties != null && schema.required != null) {
                        schema.properties.entries
                            .filter { prop -> !schema.required.contains(prop.key) }
                            .forEach { entry -> entry.value.setNullable(true) }
                    }
                }
        }
    }
}
val beans = listOf(
    libraryBeans,
    securityBeans,
    userBeans,
    ressortBeans,
    roleBeans,
    userRessortBeans,
    userRoleBeans,
)
