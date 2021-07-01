package com.yin.mvvmdemo.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.yin.mvvmdemo.db.entity.Product

@Dao
interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProducts(vararg product: Product)//vararg 可变参数

    @Insert
    fun insertBothProducts(product1: Product, product2: Product)

    @Insert
    fun insertProductAndLoveProducts(product: Product, loveProduct: List<Product>)

    @Update
    fun updateProduct(vararg product: Product)

    @Delete
    fun deleteProducts(vararg product: Product)

    @Query("SELECT * FROM products ORDER BY id DESC")
    fun loadAllProducts(): LiveData<List<Product>>

    @Query("SELECT * FROM products ORDER BY id DESC LIMIT 1")
    fun getTopProduct(): Product?

//    @Query("SELECT * FROM products WHERE name Like :search")
//    fun loadAllProductsById(search: String): Array<ProductEntity>
//
//    @Query("SELECT name, `desc` FROM PRODUCTS")
//    fun loadFullName(): Array<ProductEntity>

}