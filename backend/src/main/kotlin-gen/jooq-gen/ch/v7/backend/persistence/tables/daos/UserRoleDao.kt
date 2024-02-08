/*
 * This file is generated by jOOQ.
 */
package ch.v7.backend.persistence.tables.daos


import ch.v7.backend.persistence.tables.UserRoleTable
import ch.v7.backend.persistence.tables.pojos.UserRole
import ch.v7.backend.persistence.tables.records.UserRoleRecord

import java.util.UUID

import kotlin.collections.List

import org.jooq.Configuration
import org.jooq.Record2
import org.jooq.impl.AutoConverter
import org.jooq.impl.DAOImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class UserRoleDao(configuration: Configuration?) : DAOImpl<UserRoleRecord, UserRole, Record2<UUID?, UUID?>>(UserRoleTable.USER_ROLE, UserRole::class.java, configuration) {

    /**
     * Create a new UserRoleDao without any configuration
     */
    constructor(): this(null)

    override fun getId(o: UserRole): Record2<UUID?, UUID?> = compositeKeyRecord(o.userId, o.roleId)

    /**
     * Fetch records that have <code>user_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    fun fetchRangeOfUserId(lowerInclusive: UUID, upperInclusive: UUID): List<UserRole> = fetchRange(UserRoleTable.USER_ROLE.USER_ID, lowerInclusive, upperInclusive)

    /**
     * Fetch records that have <code>user_id IN (values)</code>
     */
    fun fetchByUserId(vararg values: UUID): List<UserRole> = fetch(UserRoleTable.USER_ROLE.USER_ID, *values)

    /**
     * Fetch records that have <code>role_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    fun fetchRangeOfRoleId(lowerInclusive: UUID, upperInclusive: UUID): List<UserRole> = fetchRange(UserRoleTable.USER_ROLE.ROLE_ID, lowerInclusive, upperInclusive)

    /**
     * Fetch records that have <code>role_id IN (values)</code>
     */
    fun fetchByRoleId(vararg values: UUID): List<UserRole> = fetch(UserRoleTable.USER_ROLE.ROLE_ID, *values)
}
