package com.yin.mvvmdemo.db

import android.util.Log
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
                        instance = DataRepository(AppDatabase.getInstance()!!)
                    }
                }
            }
            Log.w("scj", "DataRepository instance -->" + instance.hashCode())
            return instance
        }
    }

    fun insertLike(like: Like) = database.likeDao().insertLike(like)

    fun deleteLike(like: Like) = database.likeDao().deleteLikes(like.pro_id, like.user_id)

    fun insert(product: Product) = database.productDao().insertProduct(product)

    fun insertProducts(products: List<Product>) = database.productDao().insertProducts(products)

    fun queryProduct() = database.productDao().loadAllProducts()

    fun queryTopProduct() = database.productDao().getTopProduct()

    fun deleteProducts(product: Product) {
        database.productDao().deleteProducts(product)
    }

    fun updateProducts(product: Product) {
        database.productDao().updateProduct(product)
    }

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

    fun loginUser(user: User): Boolean {
        val users: Array<User>? = user.email?.let {
            user.password?.let { it1 ->
                database.userDao().loginUser(it, it1)
            }
        }
        return users != null && users.isNotEmpty()
    }
}