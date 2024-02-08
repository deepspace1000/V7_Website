/*
 * This file is generated by jOOQ.
 */
package ch.v7.backend.persistence.tables


import ch.v7.backend.persistence.Backend
import ch.v7.backend.persistence.keys.FK_USER_ROLE_ROLE
import ch.v7.backend.persistence.keys.KEY_T_ROLE_PRIMARY
import ch.v7.backend.persistence.tables.UserRoleTable.TUserRolePath
import ch.v7.backend.persistence.tables.UserTable.TUserPath
import ch.v7.backend.persistence.tables.records.RoleRecord
import ch.v7.backend.role.Roles

import java.util.UUID

import kotlin.collections.Collection

import org.jooq.Condition
import org.jooq.Field
import org.jooq.ForeignKey
import org.jooq.InverseForeignKey
import org.jooq.Name
import org.jooq.Path
import org.jooq.PlainSQL
import org.jooq.QueryPart
import org.jooq.Record
import org.jooq.SQL
import org.jooq.Schema
import org.jooq.Select
import org.jooq.Stringly
import org.jooq.Table
import org.jooq.TableField
import org.jooq.TableOptions
import org.jooq.UniqueKey
import org.jooq.impl.AutoConverter
import org.jooq.impl.DSL
import org.jooq.impl.EnumConverter
import org.jooq.impl.Internal
import org.jooq.impl.SQLDataType
import org.jooq.impl.TableImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class RoleTable(
    alias: Name,
    path: Table<out Record>?,
    childPath: ForeignKey<out Record, RoleRecord>?,
    parentPath: InverseForeignKey<out Record, RoleRecord>?,
    aliased: Table<RoleRecord>?,
    parameters: Array<Field<*>?>?,
    where: Condition?
): TableImpl<RoleRecord>(
    alias,
    Backend.BACKEND,
    path,
    childPath,
    parentPath,
    aliased,
    parameters,
    DSL.comment(""),
    TableOptions.table(),
    where,
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
    val NAME: TableField<RoleRecord, Roles?> = createField(DSL.name("name"), SQLDataType.VARCHAR(255).nullable(false), this, "", EnumConverter<String, Roles>(String::class.java, Roles::class.java))

    private constructor(alias: Name, aliased: Table<RoleRecord>?): this(alias, null, null, null, aliased, null, null)
    private constructor(alias: Name, aliased: Table<RoleRecord>?, parameters: Array<Field<*>?>?): this(alias, null, null, null, aliased, parameters, null)
    private constructor(alias: Name, aliased: Table<RoleRecord>?, where: Condition): this(alias, null, null, null, aliased, null, where)

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

    constructor(path: Table<out Record>, childPath: ForeignKey<out Record, RoleRecord>?, parentPath: InverseForeignKey<out Record, RoleRecord>?): this(Internal.createPathAlias(path, childPath, parentPath), path, childPath, parentPath, ROLE, null, null)

    /**
     * A subtype implementing {@link Path} for simplified path-based joins.
     */
    open class TRolePath : RoleTable, Path<RoleRecord> {
        constructor(path: Table<out Record>, childPath: ForeignKey<out Record, RoleRecord>?, parentPath: InverseForeignKey<out Record, RoleRecord>?): super(path, childPath, parentPath)
        private constructor(alias: Name, aliased: Table<RoleRecord>): super(alias, aliased)
        override fun `as`(alias: String): TRolePath = TRolePath(DSL.name(alias), this)
        override fun `as`(alias: Name): TRolePath = TRolePath(alias, this)
        override fun `as`(alias: Table<*>): TRolePath = TRolePath(alias.qualifiedName, this)
    }
    override fun getSchema(): Schema? = if (aliased()) null else Backend.BACKEND
    override fun getPrimaryKey(): UniqueKey<RoleRecord> = KEY_T_ROLE_PRIMARY

    private lateinit var _tUserRole: TUserRolePath

    /**
     * Get the implicit to-many join path to the
     * <code>backend.t_user_role</code> table
     */
    fun tUserRole(): TUserRolePath {
        if (!this::_tUserRole.isInitialized)
            _tUserRole = TUserRolePath(this, null, FK_USER_ROLE_ROLE.inverseKey)

        return _tUserRole;
    }

    val tUserRole: TUserRolePath
        get(): TUserRolePath = tUserRole()

    /**
     * Get the implicit many-to-many join path to the
     * <code>backend.t_user</code> table
     */
    val tUser: TUserPath
        get(): TUserPath = tUserRole().tUser()
    override fun `as`(alias: String): RoleTable = RoleTable(DSL.name(alias), this)
    override fun `as`(alias: Name): RoleTable = RoleTable(alias, this)
    override fun `as`(alias: Table<*>): RoleTable = RoleTable(alias.qualifiedName, this)

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
    override fun rename(name: Table<*>): RoleTable = RoleTable(name.qualifiedName, null)

    /**
     * Create an inline derived table from this table
     */
    override fun where(condition: Condition): RoleTable = RoleTable(qualifiedName, if (aliased()) this else null, condition)

    /**
     * Create an inline derived table from this table
     */
    override fun where(conditions: Collection<Condition>): RoleTable = where(DSL.and(conditions))

    /**
     * Create an inline derived table from this table
     */
    override fun where(vararg conditions: Condition): RoleTable = where(DSL.and(*conditions))

    /**
     * Create an inline derived table from this table
     */
    override fun where(condition: Field<Boolean?>): RoleTable = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(condition: SQL): RoleTable = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(@Stringly.SQL condition: String): RoleTable = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(@Stringly.SQL condition: String, vararg binds: Any?): RoleTable = where(DSL.condition(condition, *binds))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(@Stringly.SQL condition: String, vararg parts: QueryPart): RoleTable = where(DSL.condition(condition, *parts))

    /**
     * Create an inline derived table from this table
     */
    override fun whereExists(select: Select<*>): RoleTable = where(DSL.exists(select))

    /**
     * Create an inline derived table from this table
     */
    override fun whereNotExists(select: Select<*>): RoleTable = where(DSL.notExists(select))
}
