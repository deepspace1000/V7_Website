package ch.v7.backend.user

import ch.v7.backend.ressort.RessortDto
import ch.v7.backend.role.RoleDto

data class WhoamiDto(
    val user: UserDto,
    val ressort: List<RessortDto>,
    val role: List<RoleDto>,
)
