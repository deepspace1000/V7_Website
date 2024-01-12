/*
 * This file is generated by jOOQ.
 */
package ch.v7.backend.persistence.tables.records


import ch.v7.backend.persistence.tables.UserRessortTable
import ch.v7.backend.persistence.tables.pojos.UserRessort

import org.jetbrains.annotations.NotNull
import org.jooq.Field
import org.jooq.Record2
import org.jooq.Row2
import org.jooq.impl.UpdatableRecordImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class UserRessortRecord private constructor() : UpdatableRecordImpl<UserRessortRecord>(UserRessortTable.USER_RESSORT), Record2<String?, String?> {

    open var userId: String
        set(value): Unit = set(0, value)
    @NotNull
        get(): String = get(0) as String

    open var ressortId: String
        set(value): Unit = set(1, value)
    @NotNull
        get(): String = get(1) as String

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    override fun key(): Record2<String?, String?> = super.key() as Record2<String?, String?>

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    override fun fieldsRow(): Row2<String?, String?> = super.fieldsRow() as Row2<String?, String?>
    override fun valuesRow(): Row2<String?, String?> = super.valuesRow() as Row2<String?, String?>
    override fun field1(): Field<String?> = UserRessortTable.USER_RESSORT.USER_ID
    override fun field2(): Field<String?> = UserRessortTable.USER_RESSORT.RESSORT_ID
    override fun component1(): String = userId
    override fun component2(): String = ressortId
    override fun value1(): String = userId
    override fun value2(): String = ressortId

    override fun value1(value: String?): UserRessortRecord {
        set(0, value)
        return this
    }

    override fun value2(value: String?): UserRessortRecord {
        set(1, value)
        return this
    }

    override fun values(value1: String?, value2: String?): UserRessortRecord {
        this.value1(value1)
        this.value2(value2)
        return this
    }

    /**
     * Create a detached, initialised UserRessortRecord
     */
    constructor(userId: String, ressortId: String): this() {
        this.userId = userId
        this.ressortId = ressortId
        resetChangedOnNotNull()
    }

    /**
     * Create a detached, initialised UserRessortRecord
     */
    constructor(value: UserRessort?): this() {
        if (value != null) {
            this.userId = value.userId
            this.ressortId = value.ressortId
            resetChangedOnNotNull()
        }
    }
}