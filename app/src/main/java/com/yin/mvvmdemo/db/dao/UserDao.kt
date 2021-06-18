package com.yin.mvvmdemo.db.dao

import androidx.room.*
import com.yin.mvvmdemo.db.entity.ProductEntity
import com.yin.mvvmdemo.db.entity.UserEntity
import com.yin.mvvmdemo.viewmodel.User

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUsers(vararg users: UserEntity)//vararg 可变参数

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
    fun loadAllUsers(): Array<UserEntity>

//    @Query("SELECT * FROM products WHERE name Like :search")
//    fun loadAllProductsById(search: String): Array<ProductEntity>
//
//    @Query("SELECT name, `desc` FROM PRODUCTS")
//    fun loadFullName(): Array<ProductEntity>

}