package com.yin.mvvmdemo.db.dao

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.room.*
import com.yin.mvvmdemo.db.entity.User
import com.yin.mvvmdemo.db.entity.UserWithProduct
import com.yin.mvvmdemo.db.entity.UserWithProducts

@Dao
abstract class UserDao {

    @Transaction
    open fun regist(user: User): Boolean {
        Log.w("scj", "UserDao regist")
        val users = user.username?.let { user.email?.let { it1 -> loadUsersByColumn(it, it1) } }
        if (users != null && users.isNotEmpty()) {
            Log.w("scj", "UserDao 1111")
            for (uu in users) {
                Log.w("scj", "uu-->$uu")
            }
            return false
        } else {
            Log.w("scj", "UserDao regist 2222")
            val result = insertUsers(user)
            for (res in result) {
                Log.w("scj", "res -->$res")
            }
            return true
        }
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertUsers(vararg users: User): List<Long>//vararg 可变参数

//    @Insert
//    fun insertBothProducts(product1: ProductEntity, product2: ProductEntity)
//
//    @Insert
//    fun insertProductAndLoveProducts(product: ProductEntity, loveProduct: List<ProductEntity>)

//    @Update
//    fun updateProduct(vararg product: ProductEntity)
//
//    @Delete
//    fun deleteProducts(vararg product: ProductEntity)

    @Query("SELECT * FROM user")
    abstract fun loadAllUsers(): Array<User>

    @Query("SELECT * FROM user WHERE tb_username Like :username OR email Like :email")
    abstract fun loadUsersByColumn(username: String, email: String): Array<User>

    @Query("SELECT * FROM user WHERE email Like :email AND tb_password Like :password ORDER BY user_id DESC LIMIT 1")
    abstract fun loginUser(email: String, password: String): User?


    @Transaction
    @Query("SELECT * FROM user where user_id Like :userid")
    abstract fun getUsersWithPlaylists(userid: Long): List<UserWithProduct>

    @Transaction
    @Query("SELECT * FROM user WHERE user_id Like :user_id")
    abstract fun getFavoritesProducts(user_id: Long): LiveData<List<UserWithProducts>>


//    @Query("SELECT * FROM products WHERE name Like :search")
//    fun loadAllProductsById(search: String): Array<ProductEntity>
//
//    @Query("SELECT name, `desc` FROM PRODUCTS")
//    fun loadFullName(): Array<ProductEntity>

}