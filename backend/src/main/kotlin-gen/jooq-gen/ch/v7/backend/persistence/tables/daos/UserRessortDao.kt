/*
 * This file is generated by jOOQ.
 */
package ch.v7.backend.persistence.tables.daos


import ch.v7.backend.persistence.tables.UserRessortTable
import ch.v7.backend.persistence.tables.pojos.UserRessort
import ch.v7.backend.persistence.tables.records.UserRessortRecord

import kotlin.collections.List

import org.jooq.Configuration
import org.jooq.Record2
import org.jooq.impl.DAOImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class UserRessortDao(configuration: Configuration?) : DAOImpl<UserRessortRecord, UserRessort, Record2<String?, String?>>(UserRessortTable.USER_RESSORT, UserRessort::class.java, configuration) {

    /**
     * Create a new UserRessortDao without any configuration
     */
    constructor(): this(null)

    override fun getId(o: UserRessort): Record2<String?, String?> = compositeKeyRecord(o.userId, o.ressortId)

    /**
     * Fetch records that have <code>user_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    fun fetchRangeOfUserId(lowerInclusive: String, upperInclusive: String): List<UserRessort> = fetchRange(UserRessortTable.USER_RESSORT.USER_ID, lowerInclusive, upperInclusive)

    /**
     * Fetch records that have <code>user_id IN (values)</code>
     */
    fun fetchByUserId(vararg values: String): List<UserRessort> = fetch(UserRessortTable.USER_RESSORT.USER_ID, *values)

    /**
     * Fetch records that have <code>ressort_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    fun fetchRangeOfRessortId(lowerInclusive: String, upperInclusive: String): List<UserRessort> = fetchRange(UserRessortTable.USER_RESSORT.RESSORT_ID, lowerInclusive, upperInclusive)

    /**
     * Fetch records that have <code>ressort_id IN (values)</code>
     */
    fun fetchByRessortId(vararg values: String): List<UserRessort> = fetch(UserRessortTable.USER_RESSORT.RESSORT_ID, *values)
}