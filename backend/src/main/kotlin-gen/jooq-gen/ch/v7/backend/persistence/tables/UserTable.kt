/*
 * This file is generated by jOOQ.
 */
package ch.v7.backend.persistence.tables


import ch.v7.backend.persistence.V7Backend
import ch.v7.backend.persistence.keys.FK_USER_RESSORT_USER
import ch.v7.backend.persistence.keys.FK_USER_ROLE_USER
import ch.v7.backend.persistence.keys.KEY_T_USER_PRIMARY
import ch.v7.backend.persistence.tables.RessortTable.TRessortPath
import ch.v7.backend.persistence.tables.RoleTable.TRolePath
import ch.v7.backend.persistence.tables.UserRessortTable.TUserRessortPath
import ch.v7.backend.persistence.tables.UserRoleTable.TUserRolePath
import ch.v7.backend.persistence.tables.records.UserRecord

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
import org.jooq.impl.Internal
import org.jooq.impl.SQLDataType
import org.jooq.impl.TableImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class UserTable(
    alias: Name,
    path: Table<out Record>?,
    childPath: ForeignKey<out Record, UserRecord>?,
    parentPath: InverseForeignKey<out Record, UserRecord>?,
    aliased: Table<UserRecord>?,
    parameters: Array<Field<*>?>?,
    where: Condition?
): TableImpl<UserRecord>(
    alias,
    V7Backend.V7_BACKEND,
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
         * The reference instance of <code>v7_backend.t_user</code>
         */
        val USER: UserTable = UserTable()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<UserRecord> = UserRecord::class.java

    /**
     * The column <code>v7_backend.t_user.id</code>.
     */
    val ID: TableField<UserRecord, UUID?> = createField(DSL.name("id"), SQLDataType.CHAR(36).nullable(false), this, "", AutoConverter<String, UUID>(String::class.java, UUID::class.java))

    /**
     * The column <code>v7_backend.t_user.first_name</code>.
     */
    val FIRST_NAME: TableField<UserRecord, String?> = createField(DSL.name("first_name"), SQLDataType.VARCHAR(255).nullable(false), this, "")

    /**
     * The column <code>v7_backend.t_user.last_name</code>.
     */
    val LAST_NAME: TableField<UserRecord, String?> = createField(DSL.name("last_name"), SQLDataType.VARCHAR(255).nullable(false), this, "")

    /**
     * The column <code>v7_backend.t_user.phone</code>.
     */
    val PHONE: TableField<UserRecord, String?> = createField(DSL.name("phone"), SQLDataType.VARCHAR(255).defaultValue(DSL.field(DSL.raw("NULL"), SQLDataType.VARCHAR)), this, "")

    /**
     * The column <code>v7_backend.t_user.e_mail</code>.
     */
    val E_MAIL: TableField<UserRecord, String?> = createField(DSL.name("e_mail"), SQLDataType.VARCHAR(255).nullable(false), this, "")

    /**
     * The column <code>v7_backend.t_user.password</code>.
     */
    val PASSWORD: TableField<UserRecord, String?> = createField(DSL.name("password"), SQLDataType.VARCHAR(255).nullable(false), this, "")

    private constructor(alias: Name, aliased: Table<UserRecord>?): this(alias, null, null, null, aliased, null, null)
    private constructor(alias: Name, aliased: Table<UserRecord>?, parameters: Array<Field<*>?>?): this(alias, null, null, null, aliased, parameters, null)
    private constructor(alias: Name, aliased: Table<UserRecord>?, where: Condition): this(alias, null, null, null, aliased, null, where)

    /**
     * Create an aliased <code>v7_backend.t_user</code> table reference
     */
    constructor(alias: String): this(DSL.name(alias))

    /**
     * Create an aliased <code>v7_backend.t_user</code> table reference
     */
    constructor(alias: Name): this(alias, null)

    /**
     * Create a <code>v7_backend.t_user</code> table reference
     */
    constructor(): this(DSL.name("t_user"), null)

    constructor(path: Table<out Record>, childPath: ForeignKey<out Record, UserRecord>?, parentPath: InverseForeignKey<out Record, UserRecord>?): this(Internal.createPathAlias(path, childPath, parentPath), path, childPath, parentPath, USER, null, null)

    /**
     * A subtype implementing {@link Path} for simplified path-based joins.
     */
    open class TUserPath : UserTable, Path<UserRecord> {
        constructor(path: Table<out Record>, childPath: ForeignKey<out Record, UserRecord>?, parentPath: InverseForeignKey<out Record, UserRecord>?): super(path, childPath, parentPath)
        private constructor(alias: Name, aliased: Table<UserRecord>): super(alias, aliased)
        override fun `as`(alias: String): TUserPath = TUserPath(DSL.name(alias), this)
        override fun `as`(alias: Name): TUserPath = TUserPath(alias, this)
        override fun `as`(alias: Table<*>): TUserPath = TUserPath(alias.qualifiedName, this)
    }
    override fun getSchema(): Schema? = if (aliased()) null else V7Backend.V7_BACKEND
    override fun getPrimaryKey(): UniqueKey<UserRecord> = KEY_T_USER_PRIMARY

    private lateinit var _tUserRessort: TUserRessortPath

    /**
     * Get the implicit to-many join path to the
     * <code>v7_backend.t_user_ressort</code> table
     */
    fun tUserRessort(): TUserRessortPath {
        if (!this::_tUserRessort.isInitialized)
            _tUserRessort = TUserRessortPath(this, null, FK_USER_RESSORT_USER.inverseKey)

        return _tUserRessort;
    }

    val tUserRessort: TUserRessortPath
        get(): TUserRessortPath = tUserRessort()

    private lateinit var _tUserRole: TUserRolePath

    /**
     * Get the implicit to-many join path to the
     * <code>v7_backend.t_user_role</code> table
     */
    fun tUserRole(): TUserRolePath {
        if (!this::_tUserRole.isInitialized)
            _tUserRole = TUserRolePath(this, null, FK_USER_ROLE_USER.inverseKey)

        return _tUserRole;
    }

    val tUserRole: TUserRolePath
        get(): TUserRolePath = tUserRole()

    /**
     * Get the implicit many-to-many join path to the
     * <code>v7_backend.t_ressort</code> table
     */
    val tRessort: TRessortPath
        get(): TRessortPath = tUserRessort().tRessort()

    /**
     * Get the implicit many-to-many join path to the
     * <code>v7_backend.t_role</code> table
     */
    val tRole: TRolePath
        get(): TRolePath = tUserRole().tRole()
    override fun `as`(alias: String): UserTable = UserTable(DSL.name(alias), this)
    override fun `as`(alias: Name): UserTable = UserTable(alias, this)
    override fun `as`(alias: Table<*>): UserTable = UserTable(alias.qualifiedName, this)

    /**
     * Rename this table
     */
    override fun rename(name: String): UserTable = UserTable(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): UserTable = UserTable(name, null)

    /**
     * Rename this table
     */
    override fun rename(name: Table<*>): UserTable = UserTable(name.qualifiedName, null)

    /**
     * Create an inline derived table from this table
     */
    override fun where(condition: Condition): UserTable = UserTable(qualifiedName, if (aliased()) this else null, condition)

    /**
     * Create an inline derived table from this table
     */
    override fun where(conditions: Collection<Condition>): UserTable = where(DSL.and(conditions))

    /**
     * Create an inline derived table from this table
     */
    override fun where(vararg conditions: Condition): UserTable = where(DSL.and(*conditions))

    /**
     * Create an inline derived table from this table
     */
    override fun where(condition: Field<Boolean?>): UserTable = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(condition: SQL): UserTable = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(@Stringly.SQL condition: String): UserTable = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(@Stringly.SQL condition: String, vararg binds: Any?): UserTable = where(DSL.condition(condition, *binds))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(@Stringly.SQL condition: String, vararg parts: QueryPart): UserTable = where(DSL.condition(condition, *parts))

    /**
     * Create an inline derived table from this table
     */
    override fun whereExists(select: Select<*>): UserTable = where(DSL.exists(select))

    /**
     * Create an inline derived table from this table
     */
    override fun whereNotExists(select: Select<*>): UserTable = where(DSL.notExists(select))
}
