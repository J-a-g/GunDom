package com.yin.mvvmdemo.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.yin.mvvmdemo.db.entity.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProduct(product: Product)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProducts(product: List<Product>)

    @Insert
    fun insertBothProducts(product1: Product, product2: Product)

    @Insert
    fun insertProductAndLoveProducts(product: Product, loveProduct: List<Product>)

    @Update
    fun updateProduct(vararg product: Product)

    @Delete
    fun deleteProducts(vararg product: Product)

    @Query("SELECT * FROM products ORDER BY pd_id DESC")
    fun loadAllProducts(): Flow<List<Product>>

    @Query("SELECT * FROM products WHERE pd_brand LIKE :brand ORDER BY pd_id DESC")
    fun loadBrandProducts(brand: String): Flow<List<Product>>

//    @Query("SELECT * FROM products WHERE pd_brand LIKE :brand ORDER BY pd_id DESC")
//    fun loadBrandProductsFlow(brand: String): Flow<List<Product>>

//    @Query("SELECT * FROM products WHERE pd_brand LIKE :brand ORDER BY pd_id DESC")
//    fun loadBrandProducts2(brand: String): List<Product>

    @Query("SELECT pd_name, pd_price FROM products")
    fun getNamePrices(): List<NameTuple>

    @Query("SELECT * FROM products ORDER BY pd_id DESC LIMIT 1")
    fun getTopProduct(): Product?

    @Query("update products set likes = 1")
    fun updateAllProduct()

    @Query("update products set likes = case when products.pd_id in (select pd_id from `like` where user_id Like :user_id) then 1 else 0 end")
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