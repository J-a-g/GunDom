package com.yin.mvvmdemo.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class ProductEntity(
    @ColumnInfo(name = "name") var product_name: String?,
    @ColumnInfo(name = "desc") var product_desc: String?,
    var product_price: Double
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0


    override fun toString(): String {
        return "ProductEntity(product_name=$product_name, product_desc=$product_desc, product_price=$product_price, id=$id)"
    }


}