package ch.v7.backend.security

import jakarta.servlet.http.HttpServletRequest
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.authentication.ProviderManager
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationProvider
import org.springframework.security.web.authentication.preauth.RequestHeaderAuthenticationFilter

class UserAuthorizationFilter(
    authorizingUserDetailService: MyUserDetailService,
    @Value("\${v7.user.default-local-user:#{null}}") private val defaultTestingUser: String?,
) : RequestHeaderAuthenticationFilter() {
    init {
        setExceptionIfHeaderMissing(false)
        setPrincipalRequestHeader("Authorization")
        val provider = PreAuthenticatedAuthenticationProvider()
        provider.setPreAuthenticatedUserDetailsService(authorizingUserDetailService)
        setAuthenticationManager(ProviderManager(provider))
    }

    override fun getPreAuthenticatedPrincipal(request: HttpServletRequest): String? =
        defaultTestingUser ?: super.getPreAuthenticatedPrincipal(request) as? String
}
