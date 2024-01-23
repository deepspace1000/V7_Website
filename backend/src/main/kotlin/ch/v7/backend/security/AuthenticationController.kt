package ch.v7.backend.security

import ch.v7.backend.BackendProperties
import jakarta.servlet.http.Cookie
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

data class LoginRequest(val username: String, val password: String)
@RestController
@RequestMapping("/auth")
class AuthenticationController(
    private val jwtUtils: JwtUtils,
    private val backendProperties: BackendProperties,
) {
    @PostMapping("/login")
    fun authenticateUser(@RequestBody loginRequest: LoginRequest, response: HttpServletResponse): ResponseEntity<*> {
        val jwt = jwtUtils.generateJwtToken(loginRequest)

        // todo decide if keeping cookie or using header
        val cookie = Cookie("token", jwt).apply {
            maxAge = backendProperties.jwt.accessTokenExpiration.toInt()
            path = "/"
        }
        response.addCookie(cookie)

        return ResponseEntity.ok((jwt))
    }
}
