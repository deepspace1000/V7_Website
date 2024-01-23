package ch.v7.backend.security

import ch.v7.backend.persistence.tables.daos.UserDao
import org.springframework.context.support.beans
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.invoke
import org.springframework.security.core.Authentication
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

private const val MATCH_EVERYTHING = "/**"
private const val LOGIN_PATH = "/auth/login"
private const val PATH_OPENAPI = "/openapi/*/api-docs"
private const val PATH_SWAGGER = "/swagger-ui/index.html"

@Suppress("EMPTY_BLOCK_STRUCTURE_ERROR")
val securityBeans = beans {
    bean<UserDao>()
    bean<AuthenticationController>()
    bean<JwtAuthenticationFilter>()
    bean<AuthenticationManager> {
        AuthenticationManager { authentication: Authentication? -> authentication }
    }
    bean<JwtUtils>()
    bean<AuthenticationUserDetailsService>()
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

            // todo maybe replace with AuthorizingUserDetails (using a cookie would be nice but first find out what
            // pre-authentication is)
            addFilterBefore<UsernamePasswordAuthenticationFilter>(ref<JwtAuthenticationFilter>())

            csrf { disable() }
        }

        http.build()
    }
}
