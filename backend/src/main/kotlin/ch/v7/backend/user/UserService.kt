package ch.v7.backend.user

import ch.v7.backend.common.EntityService
import ch.v7.backend.persistence.tables.daos.UserDao
import ch.v7.backend.persistence.tables.pojos.User
import ch.v7.backend.persistence.tables.records.UserRecord
import ch.v7.backend.persistence.tables.references.USER

class UserService(private val userDao: UserDao) : EntityService<UserDto, UserRecord, User>(userDao) {
    public override fun mapToDto(pojo: User): UserDto = UserDto(
        id = pojo.id,
        email = pojo.eMail,
        firstname = pojo.firstName,
        lastname = pojo.lastName,
    )

    fun findUserByEmail(email: String) = userDao.fetchOne(USER.E_MAIL, email)
}
