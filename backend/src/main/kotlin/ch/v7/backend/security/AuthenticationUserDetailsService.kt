package ch.v7.backend.security

import ch.v7.backend.persistence.tables.daos.UserDao
import ch.v7.backend.persistence.tables.references.USER
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException

class AuthenticationUserDetailsService(private val userDao: UserDao) : UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {
        // todo password authentication
        val user = userDao.fetchOne(USER.E_MAIL, username)
            ?: throw UsernameNotFoundException("User not found with username: $username")

        return MyUserDetails(user)
    }
}
