package ch.v7.backend.security

import ch.v7.backend.persistence.tables.daos.UserDao
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken

class AuthorizingUserDetailService(private val userDao: UserDao) :
    AuthenticationUserDetailsService<PreAuthenticatedAuthenticationToken> {
    override fun loadUserDetails(token: PreAuthenticatedAuthenticationToken?): UserDetails {
        TODO(
            "Not yet implemented, lets see if it makes sense. " +
                    "would be to check if a token is valid. maybe be able to set a token in dev environment",
        )
    }
}
