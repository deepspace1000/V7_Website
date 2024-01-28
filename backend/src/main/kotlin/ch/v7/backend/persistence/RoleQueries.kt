package ch.v7.backend.persistence

import ch.v7.backend.persistence.tables.daos.RoleDao
import ch.v7.backend.persistence.tables.pojos.Role
import ch.v7.backend.persistence.tables.references.ROLE
import ch.v7.backend.persistence.tables.references.USER
import ch.v7.backend.persistence.tables.references.USER_ROLE
import java.util.UUID

fun RoleDao.fetchRolesByUserId(userId: UUID) = ctx()
    .select(ROLE)
    .from(USER_ROLE)
    .join(ROLE)
    .on(ROLE.ID.eq(USER_ROLE.ROLE_ID))
    .join(USER)
    .on(USER.ID.eq(USER_ROLE.USER_ID))
    .where(USER.ID.eq(userId))
    .fetch()
    .into(Role::class.java)
