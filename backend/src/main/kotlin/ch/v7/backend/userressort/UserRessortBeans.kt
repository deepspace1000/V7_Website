package ch.v7.backend.userressort

import ch.v7.backend.persistence.tables.daos.UserRessortDao
import org.springframework.context.support.beans

val userRessortBeans = beans {
    bean<UserRessortDao>()
}
