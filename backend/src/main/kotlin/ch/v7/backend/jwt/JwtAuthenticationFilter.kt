package ch.v7.backend.jwt

import ch.v7.backend.security.AuthenticationUserDetailsService
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.util.StringUtils
import org.springframework.web.filter.OncePerRequestFilter

private const val BEARER_TOKEN_INDEX = 7

class JwtAuthenticationFilter(private val jwtUtils: JwtUtils,
                              private val userDetailsService: AuthenticationUserDetailsService
) :
    OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain,
    ) {
        val path = request.requestURI

        if (path.startsWith("/auth")) {
            filterChain.doFilter(request, response)
        }

        val jwt = getJwtFromRequest(request)
        if (jwt.isNullOrBlank()) {
            TODO("Give some smart error or exception maybe when exception handling is implemented")
        }

        if (StringUtils.hasText(jwt) && jwtUtils.isValidJwtToken(jwt)) {
            val username = jwtUtils.getUserNameFromJwtToken(jwt)

            val userDetails = userDetailsService.loadUserByUsername(username)

            val authentication = UsernamePasswordAuthenticationToken(
                userDetails, null, userDetails.authorities,
            ).apply {
                // Todo find out what this does
                details = WebAuthenticationDetailsSource().buildDetails(request)
            }
            SecurityContextHolder.getContext().authentication = authentication
        }

        filterChain.doFilter(request, response)
    }

    private fun getJwtFromRequest(request: HttpServletRequest): String? {
        val bearerToken = request.getHeader("Authorization")
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(BEARER_TOKEN_INDEX)
        }
        return null
    }
}