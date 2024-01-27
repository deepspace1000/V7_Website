package ch.v7.backend.security

import jakarta.servlet.http.HttpServletRequest
import org.springframework.security.authentication.ProviderManager
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationProvider
import org.springframework.security.web.authentication.preauth.RequestHeaderAuthenticationFilter

class UserAuthorizationFilter (
    authorizingUserDetailService: MyUserDetailService
): RequestHeaderAuthenticationFilter() {
    init {
        setExceptionIfHeaderMissing(false)
        setPrincipalRequestHeader("USER-LOGIN-NAME")
        val provider = PreAuthenticatedAuthenticationProvider()
        provider.setPreAuthenticatedUserDetailsService(authorizingUserDetailService)
        setAuthenticationManager(ProviderManager(provider))
    }

    override fun getPreAuthenticatedPrincipal(request: HttpServletRequest): String? {
        return super.getPreAuthenticatedPrincipal(request) as? String
    }

}