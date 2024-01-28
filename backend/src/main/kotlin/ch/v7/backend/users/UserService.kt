package ch.v7.backend.users

import ch.v7.backend.common.EntityService
import ch.v7.backend.persistence.tables.daos.UserDao
import ch.v7.backend.persistence.tables.pojos.User
import ch.v7.backend.persistence.tables.records.UserRecord

class UserService(userDao: UserDao) : EntityService<UserDto, UserRecord, User>(userDao) {
    public override fun mapToDto(pojo: User): UserDto = UserDto(
        id = pojo.id,
        email = pojo.eMail,
        firstname = pojo.firstName,
        lastname = pojo.lastName,
    )
}
