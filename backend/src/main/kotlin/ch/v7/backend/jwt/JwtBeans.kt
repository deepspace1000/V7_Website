package ch.v7.backend.jwt

import com.nimbusds.jose.jwk.source.ImmutableSecret
import com.nimbusds.jose.proc.SecurityContext
import javax.crypto.spec.SecretKeySpec
import org.springframework.context.support.beans
import org.springframework.security.oauth2.jwt.JwtDecoder
import org.springframework.security.oauth2.jwt.JwtEncoder
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder

val jwtBeans = beans {
    bean<TokenService>()
    bean<JwtDecoder>{
        val secretKey = SecretKeySpec("laksdjfhasdlkfjhasdflkjhasdklfjhaslkdfjhaslkdjfhlaksjdfh".toByteArray(), "HmacSHA256")

        NimbusJwtDecoder.withSecretKey(secretKey).build()
    }
    bean<JwtEncoder>{
        val secretKey = SecretKeySpec("laksdjfhasdlkfjhasdflkjhasdklfjhaslkdfjhaslkdjfhlaksjdfh".toByteArray(), "HmacSHA256")
        val secret = ImmutableSecret<SecurityContext>(secretKey)
        NimbusJwtEncoder(secret)
    }
}