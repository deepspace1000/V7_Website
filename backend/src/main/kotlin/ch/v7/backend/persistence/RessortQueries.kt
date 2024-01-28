package ch.v7.backend.persistence

import ch.v7.backend.persistence.tables.daos.RessortDao
import ch.v7.backend.persistence.tables.pojos.Ressort
import ch.v7.backend.persistence.tables.references.RESSORT
import ch.v7.backend.persistence.tables.references.USER
import ch.v7.backend.persistence.tables.references.USER_RESSORT
import java.util.UUID

fun RessortDao.fetchRessortByUserId(userId: UUID) = ctx()
    .select(RESSORT)
    .from(USER_RESSORT)
    .join(RESSORT)
    .on(RESSORT.ID.eq(USER_RESSORT.RESSORT_ID))
    .join(USER)
    .on(USER.ID.eq(USER_RESSORT.USER_ID))
    .where(USER.ID.eq(userId))
    .fetch()
    .into(Ressort::class.java)
