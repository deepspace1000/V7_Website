/*
 * This file is generated by jOOQ.
 */
package ch.v7.backend.persistence.tables


import ch.v7.backend.persistence.Backend
import ch.v7.backend.persistence.keys.KEY_T_ROLE_PRIMARY
import ch.v7.backend.persistence.tables.records.RoleRecord

import java.util.UUID
import java.util.function.Function

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
import org.jooq.impl.AutoConverter
import org.jooq.impl.DSL
import org.jooq.impl.Internal
import org.jooq.impl.SQLDataType
import org.jooq.impl.TableImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class RoleTable(
    alias: Name,
    child: Table<out Record>?,
    path: ForeignKey<out Record, RoleRecord>?,
    aliased: Table<RoleRecord>?,
    parameters: Array<Field<*>?>?
): TableImpl<RoleRecord>(
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
         * The reference instance of <code>backend.t_role</code>
         */
        val ROLE: RoleTable = RoleTable()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<RoleRecord> = RoleRecord::class.java

    /**
     * The column <code>backend.t_role.id</code>.
     */
    val ID: TableField<RoleRecord, UUID?> = createField(DSL.name("id"), SQLDataType.CHAR(36).nullable(false), this, "", AutoConverter<String, UUID>(String::class.java, UUID::class.java))

    /**
     * The column <code>backend.t_role.name</code>.
     */
    val NAME: TableField<RoleRecord, String?> = createField(DSL.name("name"), SQLDataType.VARCHAR(255).nullable(false), this, "")

    private constructor(alias: Name, aliased: Table<RoleRecord>?): this(alias, null, null, aliased, null)
    private constructor(alias: Name, aliased: Table<RoleRecord>?, parameters: Array<Field<*>?>?): this(alias, null, null, aliased, parameters)

    /**
     * Create an aliased <code>backend.t_role</code> table reference
     */
    constructor(alias: String): this(DSL.name(alias))

    /**
     * Create an aliased <code>backend.t_role</code> table reference
     */
    constructor(alias: Name): this(alias, null)

    /**
     * Create a <code>backend.t_role</code> table reference
     */
    constructor(): this(DSL.name("t_role"), null)

    constructor(child: Table<out Record>, key: ForeignKey<out Record, RoleRecord>): this(Internal.createPathAlias(child, key), child, key, ROLE, null)
    override fun getSchema(): Schema? = if (aliased()) null else Backend.BACKEND
    override fun getPrimaryKey(): UniqueKey<RoleRecord> = KEY_T_ROLE_PRIMARY
    override fun `as`(alias: String): RoleTable = RoleTable(DSL.name(alias), this)
    override fun `as`(alias: Name): RoleTable = RoleTable(alias, this)
    override fun `as`(alias: Table<*>): RoleTable = RoleTable(alias.getQualifiedName(), this)

    /**
     * Rename this table
     */
    override fun rename(name: String): RoleTable = RoleTable(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): RoleTable = RoleTable(name, null)

    /**
     * Rename this table
     */
    override fun rename(name: Table<*>): RoleTable = RoleTable(name.getQualifiedName(), null)

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------
    override fun fieldsRow(): Row2<UUID?, String?> = super.fieldsRow() as Row2<UUID?, String?>

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    fun <U> mapping(from: (UUID?, String?) -> U): SelectField<U> = convertFrom(Records.mapping(from))

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    fun <U> mapping(toType: Class<U>, from: (UUID?, String?) -> U): SelectField<U> = convertFrom(toType, Records.mapping(from))
}