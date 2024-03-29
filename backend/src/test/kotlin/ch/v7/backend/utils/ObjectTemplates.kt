package ch.v7.backend.utils

import ch.v7.backend.persistence.tables.pojos.Ressort
import ch.v7.backend.persistence.tables.pojos.Role
import ch.v7.backend.persistence.tables.pojos.User
import ch.v7.backend.persistence.tables.pojos.UserRessort
import ch.v7.backend.persistence.tables.pojos.UserRole
import ch.v7.backend.role.Roles
import java.util.UUID

val userTemplateId: UUID = UUID.fromString("40d8b918-8f80-4b92-a3f5-4548d7883c51")
val ressortTemplateId: UUID = UUID.fromString("40d8b918-8f80-4b92-a3f5-4548d7883c52")
val roleTemplateId: UUID = UUID.fromString("40d8b918-8f80-4b92-a3f5-4548d7883c53")


fun createUserFromTemplate(
    id: UUID = userTemplateId,
    firstName: String = "test",
    lastName: String = "user",
    phone: String = "0422344323",
    eMail: String = "testuser@gmail.com",
    password: String = "\$2a\$10\$IVLBCJ8ed8zh1aYeui6Nwu4uauH/Uwtrdkd5PshFdCP9Yo0U2ltjK",
) = User(
    id = id,
    firstName = firstName,
    lastName = lastName,
    phone = phone,
    eMail = eMail,
    password = password
)

fun createRessortFromTemplate(
    id: UUID = ressortTemplateId,
    name: String = "Test Ressort",
    description: String = "Test Ressort Description"
) = Ressort(
    id = id,
    name = name,
    description = description,
)

fun createUserRessortFromTemplate(
    userId: UUID = userTemplateId,
    ressortId: UUID = ressortTemplateId,
) = UserRessort(
    userId = userId,
    ressortId = ressortId,
)

fun createRoleFromTemplate(
    id: UUID = roleTemplateId,
    name: Roles = Roles.ADMIN
) = Role(
    id = id,
    name = name,
)

fun createUserRoleFromTemplate(
    userId: UUID = userTemplateId,
    roleId: UUID = roleTemplateId,
) = UserRole(
    userId = userId,
    roleId = roleId,
)