package com.yin.mvvmdemo.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.yin.mvvmdemo.db.entity.Product
import com.yin.mvvmdemo.db.entity.ProductWithUsers
import com.yin.mvvmdemo.db.entity.Result
import com.yin.mvvmdemo.db.entity.UserWithProducts

@Dao
interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProduct(product: Product)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProducts(product: List<Product>)

    @Insert
    fun insertBothProducts(product1: Product, product2: Product)

    @Insert
    fun insertProductAndLoveProducts(product: Product, loveProduct: List<Product>)

    @Update
    fun updateProduct(vararg product: Product)

    @Delete
    fun deleteProducts(vararg product: Product)

    @Query("SELECT * FROM products ORDER BY pd_id DESC")
    fun loadAllProducts(): LiveData<List<Product>>

    @Query("SELECT * FROM products ORDER BY pd_id DESC LIMIT 1")
    fun getTopProduct(): Product?

    @Query("update products set likes = 1")
    fun updateAllProduct()

    @Query("update products set likes = 0 where products.pd_id in (select pd_id from `like` where user_id Like :user_id)")
    fun updateFavoritesProducts(user_id: Long)

    //所有用户的收藏
    @Query("select * from `like` inner join products on `like`.pd_id = products.pd_id inner join user on user.user_id = `like`.user_id")
    fun getUserAndProduct(): List<Result>

//    //所有用户的收藏
//    @Query("update products set likes = 1 (from `like` inner join products on `like`.pd_id = products.pd_id inner join user on user.user_id = `like`.user_id)")
//    fun updateUserAndProduct(): List<Result>


    @Transaction
    @Query("SELECT * FROM products")
    fun getProductsWithUsers(): List<ProductWithUsers>

    //所有用户的收藏
//    @Query("(select * from `like` where  user_id Like :userid) for update; update products set")
//    fun updateUserAndProduct(userid: Long): List<Result>

//    @Query("SELECT * FROM products WHERE name Like :search")
//    fun loadAllProductsById(search: String): Array<ProductEntity>
//
//    @Query("SELECT name, `desc` FROM PRODUCTS")
//    fun loadFullName(): Array<ProductEntity>

}