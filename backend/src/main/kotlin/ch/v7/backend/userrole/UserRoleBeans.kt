package ch.v7.backend.userrole

import ch.v7.backend.persistence.tables.daos.UserRoleDao
import org.springframework.context.support.beans

val userRoleBeans = beans {
    bean<UserRoleDao>()
}
