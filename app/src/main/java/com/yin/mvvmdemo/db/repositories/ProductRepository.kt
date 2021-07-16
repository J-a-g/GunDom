package com.yin.mvvmdemo.db.repositories

import com.yin.mvvmdemo.db.dao.ProductDao
import com.yin.mvvmdemo.db.entity.Product
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductRepository @Inject constructor(private val productDao: ProductDao) {
    fun insert(product: Product) = productDao.insertProduct(product)

    fun insertProducts(products: List<Product>) = productDao.insertProducts(products)

    fun queryProduct() = productDao.loadAllProducts()

    fun queryBrandProduct(brand: String) = productDao.loadBrandProducts(brand)
//
//    fun queryBrandProduct2(brand: String) = productDao.loadBrandProducts2(brand)

    fun queryTopProduct() = productDao.getTopProduct()

    fun deleteProducts(product: Product) {
        productDao.deleteProducts(product)
    }

    fun updateProducts(product: Product) =
        productDao.updateProduct(product)

    fun updateFavoritesProducts(user_id: Long) =
        productDao.updateFavoritesProducts(user_id)

    fun updateAllProducts() = productDao.updateAllProduct()

    fun getProductsWithUsers() = productDao.getProductsWithUsers()

    fun getUserAndProduct() = productDao.getUserAndProduct()
}