package ch.v7.backend.security

import ch.v7.backend.persistence.tables.daos.UserDao

class UserAccessAuthorizer(private val userDao: UserDao) {
    fun isUser(myUserDetails: MyUserDetails): Boolean = myUserDetails.username == "nilsrothe05@gmail.com"


    fun isWrongUser(myUserDetails: MyUserDetails): Boolean = myUserDetails.username == "globi@gmail.com"
}