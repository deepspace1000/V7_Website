package ch.v7.backend.security

import ch.v7.backend.BackendProperties
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.MalformedJwtException
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.UnsupportedJwtException
import java.util.Date

class JwtUtils(private val backendProperties: BackendProperties) {
    fun generateJwtToken(authentication: LoginRequest): String = Jwts.builder()
        .setSubject(authentication.username)
        .setIssuedAt(Date())
        .setExpiration(Date(Date().time + backendProperties.jwt.accessTokenExpiration))
        .signWith(SignatureAlgorithm.HS512, backendProperties.jwt.key)
        .compact()

    // todo some smart error handling here too
    fun isValidJwtToken(token: String): Boolean {
        try {
            Jwts.parser().setSigningKey(backendProperties.jwt.key).parseClaimsJws(token)
            return true
        } catch (e: MalformedJwtException) {
            // handle invalid JWT format
        } catch (e: UnsupportedJwtException) {
            // handle unsupported JWT
        } catch (e: IllegalArgumentException) {
            // handle empty or null JWT
        }

        return false
    }

    fun getUserNameFromJwtToken(token: String): String = Jwts.parser()
        .setSigningKey(backendProperties.jwt.key)
        .parseClaimsJws(token)
        .body
        .subject
}
