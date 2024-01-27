package ch.v7.backend.users

import org.springframework.context.support.beans

val userBeans = beans {
    bean<UserRessource>()
}
