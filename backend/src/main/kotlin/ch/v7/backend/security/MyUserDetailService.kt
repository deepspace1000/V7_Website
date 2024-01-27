package ch.v7.backend.security

import ch.v7.backend.persistence.tables.daos.UserDao
import ch.v7.backend.persistence.tables.references.USER
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken

class MyUserDetailService(private val userDao: UserDao) :
    AuthenticationUserDetailsService<PreAuthenticatedAuthenticationToken> {
    override fun loadUserDetails(token: PreAuthenticatedAuthenticationToken?): UserDetails {
        token ?: throw UsernameNotFoundException("No token received")

        val user = userDao.fetchOne(USER.E_MAIL, token.principal as String)
            ?: throw UsernameNotFoundException("User not found for E-Mail ${token.principal}")

        println("My user details service ${user.eMail}" )
        return MyUserDetails(user)
    }
}

