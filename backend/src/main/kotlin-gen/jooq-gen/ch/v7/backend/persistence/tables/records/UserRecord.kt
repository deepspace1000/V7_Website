/*
 * This file is generated by jOOQ.
 */
package ch.v7.backend.persistence.tables.records


import ch.v7.backend.persistence.tables.UserTable
import ch.v7.backend.persistence.tables.pojos.User

import java.util.UUID

import org.jetbrains.annotations.NotNull
import org.jetbrains.annotations.Nullable
import org.jooq.Record1
import org.jooq.impl.UpdatableRecordImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class UserRecord private constructor() : UpdatableRecordImpl<UserRecord>(UserTable.USER) {

    open var id: UUID
        set(value): Unit = set(0, value)
    @NotNull
        get(): UUID = get(0) as UUID

    open var firstName: String
        set(value): Unit = set(1, value)
    @NotNull
        get(): String = get(1) as String

    open var lastName: String
        set(value): Unit = set(2, value)
    @NotNull
        get(): String = get(2) as String

    open var phone: String?
        set(value): Unit = set(3, value)
    @Nullable
        get(): String? = get(3) as String?

    open var eMail: String
        set(value): Unit = set(4, value)
    @NotNull
        get(): String = get(4) as String

    open var password: String
        set(value): Unit = set(5, value)
    @NotNull
        get(): String = get(5) as String

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    override fun key(): Record1<UUID?> = super.key() as Record1<UUID?>

    /**
     * Create a detached, initialised UserRecord
     */
    constructor(id: UUID, firstName: String, lastName: String, phone: String? = null, eMail: String, password: String): this() {
        this.id = id
        this.firstName = firstName
        this.lastName = lastName
        this.phone = phone
        this.eMail = eMail
        this.password = password
        resetChangedOnNotNull()
    }

    /**
     * Create a detached, initialised UserRecord
     */
    constructor(value: User?): this() {
        if (value != null) {
            this.id = value.id
            this.firstName = value.firstName
            this.lastName = value.lastName
            this.phone = value.phone
            this.eMail = value.eMail
            this.password = value.password
            resetChangedOnNotNull()
        }
    }
}
