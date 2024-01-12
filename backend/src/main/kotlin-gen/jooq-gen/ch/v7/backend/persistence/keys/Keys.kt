/*
 * This file is generated by jOOQ.
 */
package ch.v7.backend.persistence.keys


import ch.v7.backend.persistence.tables.RessortTable
import ch.v7.backend.persistence.tables.UserRessortTable
import ch.v7.backend.persistence.tables.UserTable
import ch.v7.backend.persistence.tables.records.RessortRecord
import ch.v7.backend.persistence.tables.records.UserRecord
import ch.v7.backend.persistence.tables.records.UserRessortRecord

import org.jooq.ForeignKey
import org.jooq.UniqueKey
import org.jooq.impl.DSL
import org.jooq.impl.Internal



// -------------------------------------------------------------------------
// UNIQUE and PRIMARY KEY definitions
// -------------------------------------------------------------------------

val KEY_T_RESSORT_PRIMARY: UniqueKey<RessortRecord> = Internal.createUniqueKey(RessortTable.RESSORT, DSL.name("KEY_t_ressort_PRIMARY"), arrayOf(RessortTable.RESSORT.ID), true)
val KEY_T_USER_PRIMARY: UniqueKey<UserRecord> = Internal.createUniqueKey(UserTable.USER, DSL.name("KEY_t_user_PRIMARY"), arrayOf(UserTable.USER.ID), true)
val KEY_T_USER_RESSORT_PRIMARY: UniqueKey<UserRessortRecord> = Internal.createUniqueKey(UserRessortTable.USER_RESSORT, DSL.name("KEY_t_user_ressort_PRIMARY"), arrayOf(UserRessortTable.USER_RESSORT.USER_ID, UserRessortTable.USER_RESSORT.RESSORT_ID), true)

// -------------------------------------------------------------------------
// FOREIGN KEY definitions
// -------------------------------------------------------------------------

val FK_USER_RESSORT_RESSORT: ForeignKey<UserRessortRecord, RessortRecord> = Internal.createForeignKey(UserRessortTable.USER_RESSORT, DSL.name("fk_user_ressort_ressort"), arrayOf(UserRessortTable.USER_RESSORT.RESSORT_ID), ch.v7.backend.persistence.keys.KEY_T_RESSORT_PRIMARY, arrayOf(RessortTable.RESSORT.ID), true)
val FK_USER_RESSORT_USER: ForeignKey<UserRessortRecord, UserRecord> = Internal.createForeignKey(UserRessortTable.USER_RESSORT, DSL.name("fk_user_ressort_user"), arrayOf(UserRessortTable.USER_RESSORT.USER_ID), ch.v7.backend.persistence.keys.KEY_T_USER_PRIMARY, arrayOf(UserTable.USER.ID), true)