package ch.v7.backend.role

import ch.v7.backend.common.EntityService
import ch.v7.backend.persistence.fetchRolesByUserId
import ch.v7.backend.persistence.tables.daos.RoleDao
import ch.v7.backend.persistence.tables.pojos.Role
import ch.v7.backend.persistence.tables.records.RoleRecord
import java.util.UUID

class RoleService(private val roleDao: RoleDao) : EntityService<RoleDto, RoleRecord, Role>(roleDao) {
    public override fun mapToDto(pojo: Role): RoleDto = RoleDto(
        id = pojo.id,
        name = pojo.name,
    )

    fun getRolesForUserById(userId: UUID) = roleDao.fetchRolesByUserId(userId).map(::mapToDto)
}
