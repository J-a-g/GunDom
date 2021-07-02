package com.yin.mvvmdemo.db

import android.util.Log
import com.yin.mvvmdemo.db.entity.Product
import com.yin.mvvmdemo.db.entity.UserEntity

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

    fun insertUser(user: UserEntity) = database.userDao().insertUsers(user)

    fun queryUsers(): Array<UserEntity> = database.userDao().loadAllUsers()

    fun registUser(user: UserEntity): Boolean = database.userDao().regist(user)

    fun queryUserByColumn(user: UserEntity): Array<UserEntity>? =
        user.username?.let {
            user.email?.let { it1 ->
                database.userDao().loadUsersByColumn(
                    it,
                    it1
                )
            }
        }

    fun loginUser(user: UserEntity): Boolean {
        val users: Array<UserEntity>? = user.username?.let {
            user.password?.let { it1 ->
                database.userDao().loginUser(it, it1)
            }
        }
        return users != null && users.isNotEmpty()
    }
}