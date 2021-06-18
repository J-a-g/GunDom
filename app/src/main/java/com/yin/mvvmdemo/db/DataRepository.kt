package com.yin.mvvmdemo.db

import android.util.Log
import com.yin.mvvmdemo.db.entity.ProductEntity

class DataRepository(private val database: AppDatabase) {


    companion object {
        @Volatile
        private var instance: DataRepository? = null

        fun getInstance(database: AppDatabase): DataRepository? {
            if (instance == null) {
                synchronized(DataRepository::class.java) {
                    if (instance == null) {
                        instance = DataRepository(database)
                    }
                }
            }
            Log.w("scj", "DataRepository instance -->" + instance.hashCode())
            return instance
        }
    }

    fun insert(product: ProductEntity) {
        database.productDao().insertProducts(product)
    }

    fun queryProduct(): Array<ProductEntity> {
        return database.productDao().loadAllProducts()
    }

    fun deleteProducts(product: ProductEntity){
        database.productDao().deleteProducts(product)
    }

    fun updateProducts(product: ProductEntity){
        database.productDao().updateProduct(product)
    }
}