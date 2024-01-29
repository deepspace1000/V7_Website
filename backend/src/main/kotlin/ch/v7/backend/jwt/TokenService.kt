package ch.v7.backend.jwt

import ch.v7.backend.persistence.tables.daos.UserDao
import ch.v7.backend.persistence.tables.pojos.User
import ch.v7.backend.user.UserService
import java.lang.Exception
import java.time.Instant
import java.time.temporal.ChronoUnit
import java.util.UUID
import org.springframework.security.oauth2.jwt.JwsHeader
import org.springframework.security.oauth2.jwt.JwtClaimsSet
import org.springframework.security.oauth2.jwt.JwtDecoder
import org.springframework.security.oauth2.jwt.JwtEncoder
import org.springframework.security.oauth2.jwt.JwtEncoderParameters

class TokenService (private val userService: UserService, private val jwtEncoder: JwtEncoder, private val jwtDecoder: JwtDecoder){
    fun createToken(user: User): String {
        val jwsHeader = JwsHeader.with { "HS256" }.build()
        val claims = JwtClaimsSet.builder()
            .issuedAt(Instant.now())
            .expiresAt(Instant.now().plus(30L, ChronoUnit.DAYS))
            .subject(user.eMail)
            .claim("userId", user.id)
            .build()
        return jwtEncoder.encode(JwtEncoderParameters.from(jwsHeader, claims)).tokenValue
    }


    fun parseToken(token: String): User? {
        return try {
            val jwt = jwtDecoder.decode(token)
            val email = jwt.subject as String
            userService.findUserByEmail(email)
            // find out how to do id
        } catch (e: Exception) {
            null
        }
    }
}