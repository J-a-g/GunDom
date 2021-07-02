package com.yin.mvvmdemo.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class Product(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long = 0,
    @ColumnInfo(name = "pd_name") var name: String ="",
    @ColumnInfo(name = "pd_price") var price: Double = 0.0,
    @ColumnInfo(name = "pd_brand") var brand: String = "",
    var like: Int = 0,
    @ColumnInfo(name = "pd_description") var description: String = "",
    @ColumnInfo(name = "pd_imgUrl") var imageUrl: String = ""

) {

    override fun toString(): String {
        return "Product(name='$name', description='$description', price=$price, brand='$brand', imageUrl='$imageUrl', id=$id, like=$like)"
    }
}