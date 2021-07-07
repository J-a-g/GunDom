package com.yin.mvvmdemo.db.entity

import android.graphics.Bitmap
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class Product(
    @PrimaryKey(autoGenerate = true)
    var pd_id: Long = 0,
    @ColumnInfo(name = "pd_name") var name: String ="",
    @ColumnInfo(name = "pd_price") var price: Double = 0.0,
    @ColumnInfo(name = "pd_brand") var brand: String = "",
    var likes: Int = 0,
    @ColumnInfo(name = "pd_description") var description: String = "",
    @ColumnInfo(name = "pd_imgUrl") var imageUrl: String = ""
//    @Ignore val picture: Bitmap?  忽略字段

) {

    override fun toString(): String {
        return "Product(name='$name', description='$description', price=$price, brand='$brand', imageUrl='$imageUrl', id=$pd_id, like=$likes)"
    }
}