package ch.v7.backend.user

import org.springframework.context.support.beans

val userBeans = beans {
    bean<UserRessource>()
    bean<UserService>()
}
