/*
 * This file is generated by jOOQ.
 */
package ch.v7.backend.persistence.tables.pojos


import ch.v7.backend.role.Roles

import java.io.Serializable
import java.util.UUID


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
data class Role(
    val id: UUID,
    val name: Roles
): Serializable {

    override fun equals(other: Any?): Boolean {
        if (this === other)
            return true
        if (other == null)
            return false
        if (this::class != other::class)
            return false
        val o: Role = other as Role
        if (this.id != o.id)
            return false
        if (this.name != o.name)
            return false
        return true
    }

    override fun hashCode(): Int {
        val prime = 31
        var result = 1
        result = prime * result + this.id.hashCode()
        result = prime * result + this.name.hashCode()
        return result
    }

    override fun toString(): String {
        val sb = StringBuilder("Role (")

        sb.append(id)
        sb.append(", ").append(name)

        sb.append(")")
        return sb.toString()
    }
}
