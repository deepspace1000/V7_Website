package ch.v7.backend.ressort

import java.util.UUID

data class RessortDto(
    val id: UUID,
    val name: String,
    val description: String?,
)
