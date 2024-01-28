package ch.v7.backend.ressort

import ch.v7.backend.common.EntityService
import ch.v7.backend.persistence.fetchRessortByUserId
import ch.v7.backend.persistence.tables.daos.RessortDao
import ch.v7.backend.persistence.tables.pojos.Ressort
import ch.v7.backend.persistence.tables.records.RessortRecord
import java.util.UUID

class RessortService(private val ressortDao: RessortDao) : EntityService<RessortDto, RessortRecord, Ressort>(
    ressortDao,
) {
    public override fun mapToDto(pojo: Ressort): RessortDto = RessortDto(
        id = pojo.id,
        name = pojo.name,
        description = pojo.description,

    )

    fun getRessortsForUser(userId: UUID) = ressortDao.fetchRessortByUserId(userId).map(::mapToDto)
}
