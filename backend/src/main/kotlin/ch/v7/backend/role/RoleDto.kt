package ch.v7.backend.role

import java.util.UUID

enum class Roles {
    ADMIN,
    LEADER,
    TEEN,
    ;
}

data class RoleDto(
    val id: UUID,
    val name: Roles,
)
