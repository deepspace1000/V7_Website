/*
 * This file is generated by jOOQ.
 */
package ch.v7.backend.persistence.tables


import ch.v7.backend.persistence.Backend
import ch.v7.backend.persistence.keys.FK_USER_RESSORT_RESSORT
import ch.v7.backend.persistence.keys.FK_USER_RESSORT_USER
import ch.v7.backend.persistence.keys.KEY_T_USER_RESSORT_PRIMARY
import ch.v7.backend.persistence.tables.records.UserRessortRecord

import java.util.function.Function

import kotlin.collections.List

import org.jooq.Field
import org.jooq.ForeignKey
import org.jooq.Name
import org.jooq.Record
import org.jooq.Records
import org.jooq.Row2
import org.jooq.Schema
import org.jooq.SelectField
import org.jooq.Table
import org.jooq.TableField
import org.jooq.TableOptions
import org.jooq.UniqueKey
import org.jooq.impl.DSL
import org.jooq.impl.Internal
import org.jooq.impl.SQLDataType
import org.jooq.impl.TableImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class UserRessortTable(
    alias: Name,
    child: Table<out Record>?,
    path: ForeignKey<out Record, UserRessortRecord>?,
    aliased: Table<UserRessortRecord>?,
    parameters: Array<Field<*>?>?
): TableImpl<UserRessortRecord>(
    alias,
    Backend.BACKEND,
    child,
    path,
    aliased,
    parameters,
    DSL.comment(""),
    TableOptions.table()
) {
    companion object {

        /**
         * The reference instance of <code>backend.t_user_ressort</code>
         */
        val USER_RESSORT: UserRessortTable = UserRessortTable()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<UserRessortRecord> = UserRessortRecord::class.java

    /**
     * The column <code>backend.t_user_ressort.user_id</code>.
     */
    val USER_ID: TableField<UserRessortRecord, String?> = createField(DSL.name("user_id"), SQLDataType.CHAR(36).nullable(false), this, "")

    /**
     * The column <code>backend.t_user_ressort.ressort_id</code>.
     */
    val RESSORT_ID: TableField<UserRessortRecord, String?> = createField(DSL.name("ressort_id"), SQLDataType.CHAR(36).nullable(false), this, "")

    private constructor(alias: Name, aliased: Table<UserRessortRecord>?): this(alias, null, null, aliased, null)
    private constructor(alias: Name, aliased: Table<UserRessortRecord>?, parameters: Array<Field<*>?>?): this(alias, null, null, aliased, parameters)

    /**
     * Create an aliased <code>backend.t_user_ressort</code> table reference
     */
    constructor(alias: String): this(DSL.name(alias))

    /**
     * Create an aliased <code>backend.t_user_ressort</code> table reference
     */
    constructor(alias: Name): this(alias, null)

    /**
     * Create a <code>backend.t_user_ressort</code> table reference
     */
    constructor(): this(DSL.name("t_user_ressort"), null)

    constructor(child: Table<out Record>, key: ForeignKey<out Record, UserRessortRecord>): this(Internal.createPathAlias(child, key), child, key, USER_RESSORT, null)
    override fun getSchema(): Schema? = if (aliased()) null else Backend.BACKEND
    override fun getPrimaryKey(): UniqueKey<UserRessortRecord> = KEY_T_USER_RESSORT_PRIMARY
    override fun getReferences(): List<ForeignKey<UserRessortRecord, *>> = listOf(FK_USER_RESSORT_USER, FK_USER_RESSORT_RESSORT)

    private lateinit var _tUser: UserTable
    private lateinit var _tRessort: RessortTable

    /**
     * Get the implicit join path to the <code>backend.t_user</code> table.
     */
    fun tUser(): UserTable {
        if (!this::_tUser.isInitialized)
            _tUser = UserTable(this, FK_USER_RESSORT_USER)

        return _tUser;
    }

    val tUser: UserTable
        get(): UserTable = tUser()

    /**
     * Get the implicit join path to the <code>backend.t_ressort</code> table.
     */
    fun tRessort(): RessortTable {
        if (!this::_tRessort.isInitialized)
            _tRessort = RessortTable(this, FK_USER_RESSORT_RESSORT)

        return _tRessort;
    }

    val tRessort: RessortTable
        get(): RessortTable = tRessort()
    override fun `as`(alias: String): UserRessortTable = UserRessortTable(DSL.name(alias), this)
    override fun `as`(alias: Name): UserRessortTable = UserRessortTable(alias, this)
    override fun `as`(alias: Table<*>): UserRessortTable = UserRessortTable(alias.getQualifiedName(), this)

    /**
     * Rename this table
     */
    override fun rename(name: String): UserRessortTable = UserRessortTable(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): UserRessortTable = UserRessortTable(name, null)

    /**
     * Rename this table
     */
    override fun rename(name: Table<*>): UserRessortTable = UserRessortTable(name.getQualifiedName(), null)

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------
    override fun fieldsRow(): Row2<String?, String?> = super.fieldsRow() as Row2<String?, String?>

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    fun <U> mapping(from: (String?, String?) -> U): SelectField<U> = convertFrom(Records.mapping(from))

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    fun <U> mapping(toType: Class<U>, from: (String?, String?) -> U): SelectField<U> = convertFrom(toType, Records.mapping(from))
}