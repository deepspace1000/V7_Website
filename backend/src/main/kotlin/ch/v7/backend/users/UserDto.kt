package ch.v7.backend.users

import java.util.UUID

data class UserDto(
    val id: UUID,
    val email: String,
    val firstname: String,
    val lastname: String,
)
