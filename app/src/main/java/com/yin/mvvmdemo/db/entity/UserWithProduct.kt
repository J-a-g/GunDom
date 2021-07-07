package com.yin.mvvmdemo.db.entity

import androidx.room.Embedded
import androidx.room.Relation

//一对多关系,一个user对多个Product，使用这个关系时，product中要有一个字段用于关连user_id,
// 而entityColumn = "pd_id"并不是和user_id相互关联，所以不能使用一对多关系
data class UserWithProduct(
    @Embedded
    val user: User,
    @Relation(
        parentColumn = "user_id",
        entityColumn = "pd_id"
    )
    val favoritesProduct: List<Product>
) {
    override fun toString(): String {
        return "UserWithProduct(user=$user, favoritesProduct=$favoritesProduct)"
    }
}
