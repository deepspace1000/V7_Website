package ch.v7.backend.security

import ch.v7.backend.persistence.tables.daos.UserDao
import org.springframework.context.support.beans
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.invoke
import org.springframework.security.core.Authentication
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.preauth.RequestHeaderAuthenticationFilter

private const val MATCH_EVERYTHING = "/**"
private const val LOGIN_PATH = "/auth/login"
private const val PATH_OPENAPI = "/openapi/*/api-docs"
private const val PATH_SWAGGER = "/swagger-ui/index.html"

@Suppress("EMPTY_BLOCK_STRUCTURE_ERROR")
val securityBeans = beans {
    bean<UserAccessAuthorizer>("UserAccessAuthorizer")
    bean<MyUserDetailService>()
    bean<UserAuthorizationFilter>()
    bean<UserDao>()
    bean<AuthenticationManager> {
        AuthenticationManager { authentication: Authentication? -> authentication }
    }
    bean<SecurityFilterChain> {
        val http = ref<HttpSecurity>()

        http {
            authorizeHttpRequests {
                authorize(PATH_OPENAPI, permitAll)
                authorize(PATH_SWAGGER, permitAll)
                authorize(LOGIN_PATH, permitAll)
                authorize(MATCH_EVERYTHING, authenticated)
            }

            httpBasic { }

            addFilterBefore<RequestHeaderAuthenticationFilter>(ref<UserAuthorizationFilter>())

            csrf { disable() }
        }

        http.build()
    }
}
