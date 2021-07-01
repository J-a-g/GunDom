package com.yin.mvvmdemo.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class Product(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    @ColumnInfo(name = "name")
    var product_name: String = "name:" + System.currentTimeMillis(),
    @ColumnInfo(name = "desc")
    var product_desc: String = "描述",
    var product_price: Double = 0.0,
    var product_imageUrl: String = ""
) {

    override fun toString(): String {
        return "ProductEntity(product_name=$product_name, product_desc=$product_desc, product_price=$product_price, product_imageUrl=$product_imageUrl, id=$id)"
    }

}