package com.yin.mvvmdemo.db.repositories

import com.yin.mvvmdemo.db.dao.UserDao
import com.yin.mvvmdemo.db.entity.User
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(private val userDao: UserDao) {

    fun getUsersWithPlaylists(user_id: Long) = userDao.getUsersWithPlaylists(user_id)

    fun getFavoritesProducts(user_id: Long) = userDao.getFavoritesProducts(user_id)

    fun insertUser(user: User) = userDao.insertUsers(user)

    fun queryUsers(): Array<User> = userDao.loadAllUsers()

    fun registUser(user: User): Boolean = userDao.regist(user)

    fun queryUserByColumn(user: User): Array<User>? =
        user.username?.let {
            user.email?.let { it1 ->
                userDao.loadUsersByColumn(
                    it,
                    it1
                )
            }
        }

    fun loginUser(user: User): User? {
        return user.email?.let {
            user.password?.let { it1 ->
                userDao.loginUser(it, it1)
            }
        }
    }
}