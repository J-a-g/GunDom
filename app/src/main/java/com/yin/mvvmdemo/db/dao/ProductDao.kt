package com.yin.mvvmdemo.db.dao

import androidx.room.*
import com.yin.mvvmdemo.db.entity.ProductEntity

@Dao
interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProducts(vararg product: ProductEntity)//vararg 可变参数

    @Insert
    fun insertBothProducts(product1: ProductEntity, product2: ProductEntity)

    @Insert
    fun insertProductAndLoveProducts(product: ProductEntity, loveProduct: List<ProductEntity>)

    @Update
    fun updateProduct(vararg product: ProductEntity)

    @Delete
    fun deleteProducts(vararg product: ProductEntity)

    @Query("SELECT * FROM products")
    fun loadAllProducts(): Array<ProductEntity>

//    @Query("SELECT * FROM products WHERE name Like :search")
//    fun loadAllProductsById(search: String): Array<ProductEntity>
//
//    @Query("SELECT name, `desc` FROM PRODUCTS")
//    fun loadFullName(): Array<ProductEntity>

}