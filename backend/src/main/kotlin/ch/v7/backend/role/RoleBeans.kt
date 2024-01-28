package ch.v7.backend.role

import ch.v7.backend.persistence.tables.daos.RoleDao
import org.springframework.context.support.beans

val roleBeans = beans {
    bean<RoleService>()
    bean<RoleDao>()
}
