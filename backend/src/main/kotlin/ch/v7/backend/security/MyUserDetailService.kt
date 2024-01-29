package ch.v7.backend.security

import ch.v7.backend.jwt.TokenService
import ch.v7.backend.persistence.tables.daos.UserDao
import ch.v7.backend.persistence.tables.references.USER
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken

class MyUserDetailService(private val userDao: UserDao, private val tokenService: TokenService) :
    AuthenticationUserDetailsService<PreAuthenticatedAuthenticationToken> {
    override fun loadUserDetails(token: PreAuthenticatedAuthenticationToken?): UserDetails {
        println(token)
        token ?: throw UsernameNotFoundException("No token received")

        val tokenUser = tokenService.parseToken(token.principal.toString().substring(7)) ?: throw UsernameNotFoundException("Fuking token sött nöd mal bis da hi cho")

        println(tokenUser.eMail)
        val user = userDao.fetchOne(USER.E_MAIL, tokenUser.eMail)
            ?: throw UsernameNotFoundException("User not found for E-Mail ${token.principal}")



        return MyUserDetails(user)
    }
}
