package ch.v7.backend.jwt

import org.springframework.context.support.beans

val jwtBeans = beans {
    bean<TokenService>()
}
