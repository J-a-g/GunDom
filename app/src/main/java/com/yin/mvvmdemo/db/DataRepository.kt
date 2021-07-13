package com.yin.mvvmdemo.db

import android.util.Log
import androidx.lifecycle.LiveData
import com.yin.mvvmdemo.BasicApp
import com.yin.mvvmdemo.db.entity.Like
import com.yin.mvvmdemo.db.entity.Product
import com.yin.mvvmdemo.db.entity.User

class DataRepository(private val database: AppDatabase) {


    companion object {
        @Volatile
        private var instance: DataRepository? = null

        fun getInstance(): DataRepository? {
            if (instance == null) {
                synchronized(DataRepository::class.java) {
                    if (instance == null) {
                        instance = DataRepository(AppDatabase.getInstance(BasicApp.instance)!!)
                    }
                }
            }
            Log.w("scj", "DataRepository instance -->" + instance.hashCode())
            return instance
        }
    }

    fun queryLikseByUserId(user_id: Long) = database.likeDao().queryLikesByUserId(user_id)

    fun insertLike(like: Like) = database.likeDao().insertLike(like)

    fun deleteLike(like: Like) = database.likeDao().deleteLikes(like.pd_id, like.user_id)


    fun getUsersWithPlaylists(user_id: Long) = database.userDao().getUsersWithPlaylists(user_id)

    fun getFavoritesProducts(user_id: Long) = database.userDao().getFavoritesProducts(user_id)

    fun insertUser(user: User) = database.userDao().insertUsers(user)

    fun queryUsers(): Array<User> = database.userDao().loadAllUsers()

    fun registUser(user: User): Boolean = database.userDao().regist(user)

    fun queryUserByColumn(user: User): Array<User>? =
        user.username?.let {
            user.email?.let { it1 ->
                database.userDao().loadUsersByColumn(
                    it,
                    it1
                )
            }
        }

    fun loginUser(user: User): User? {
        return user.email?.let {
            user.password?.let { it1 ->
                database.userDao().loginUser(it, it1)
            }
        }
    }
}