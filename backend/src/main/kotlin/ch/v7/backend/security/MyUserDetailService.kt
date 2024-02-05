package ch.v7.backend.security

import ch.v7.backend.common.V7AuthorizationException
import ch.v7.backend.jwt.TokenService
import ch.v7.backend.persistence.tables.daos.UserDao
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken

private const val TOKEN_SUBSTRING = 7
class MyUserDetailService(private val userDao: UserDao, private val tokenService: TokenService) :
    AuthenticationUserDetailsService<PreAuthenticatedAuthenticationToken> {
    override fun loadUserDetails(token: PreAuthenticatedAuthenticationToken?): UserDetails {
        token ?: throw UsernameNotFoundException("No token received")

        try {
            val tokenUser = tokenService.parseIdFromToken(token.principal.toString().substring(TOKEN_SUBSTRING))

            val user = userDao.fetchOneById(tokenUser)
                ?: throw UsernameNotFoundException("User not found for E-Mail ${token.principal}")

            return MyUserDetails(user)
        } catch (e: V7AuthorizationException) {
            throw AuthenticationCredentialsNotFoundException("Invalid token", e)
        }
    }
}
