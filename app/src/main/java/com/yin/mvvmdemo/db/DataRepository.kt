package com.yin.mvvmdemo.db

import android.util.Log
import androidx.lifecycle.LiveData
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

    fun queryLikseByUserId(user_id: Long) = database.likeDao().queryLikesByUserId(user_id)

    fun insertLike(like: Like) = database.likeDao().insertLike(like)

    fun deleteLike(like: Like) = database.likeDao().deleteLikes(like.pd_id, like.user_id)

    fun insert(product: Product) = database.productDao().insertProduct(product)

    fun insertProducts(products: List<Product>) = database.productDao().insertProducts(products)

    fun queryProduct() = database.productDao().loadAllProducts()

    fun queryTopProduct() = database.productDao().getTopProduct()

    fun deleteProducts(product: Product) {
        database.productDao().deleteProducts(product)
    }

    fun updateProducts(product: Product) =
        database.productDao().updateProduct(product)

    fun updateFavoritesProducts(user_id: Long) =
        database.productDao().updateFavoritesProducts(user_id)

    fun updateAllProducts() = database.productDao().updateAllProduct()

    fun getProductsWithUsers() = database.productDao().getProductsWithUsers()

    fun getUserAndProduct() = database.productDao().getUserAndProduct()

    fun getUsersWithPlaylists(user_id: Long) = database.userDao().getUsersWithPlaylists(user_id)

    fun getFavoritesProducts(user_id: Long) = database.userDao().getFavoritesProducts(user_id)

    fun insertUser(user: User) = database.userDao().insertUsers(user)

    fun queryUsers(): Array<User> = database.userDao().loadAllUsers()

    fun registUser(user: User): Boolean = database.userDao().regist(user)

    fun queryProductByUserLikes(user_id: Long): LiveData<List<Product>> {
        val likes = queryLikseByUserId(user_id)
        val list: ArrayList<Long> = ArrayList()
        for (like in likes) {
            list.add(like.pd_id)
        }
        Log.w("scj", "likes.size->" + likes.size + " list:" + list.size)
        val products = queryProduct()
        val list2: List<Product>? = products.value
        if (list2 != null) {
            for (kk in list2) {
                Log.w("scj", "it-> " + kk.toString())
            }
        } else {
            Log.w("scj", "list2 为 null")
        }
        Log.w("scj", "test:" + list2)

        products.value?.toMutableList()?.forEach {
            Log.w("scj", "it-> " + it.toString())
        }
        for (product in products.value?.toMutableList().orEmpty()) {
            Log.w("scj", "kkkkkkkkkk")
            if (list.contains(product.pd_id)) {
                Log.w("scj", "11111111111111")
                product.likes = 1
            } else {
                Log.w("scj", "222222222222")
                product.likes = 0
            }
        }
        return products
    }

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