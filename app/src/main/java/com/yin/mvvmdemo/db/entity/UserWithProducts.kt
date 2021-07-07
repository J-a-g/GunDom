package com.yin.mvvmdemo.db.entity

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

class UserWithProducts(
    @Embedded
    val user: User,
    @Relation(
        parentColumn = "user_id",
        entityColumn = "pd_id",

        associateBy = Junction(Like::class)
    )
    val products: List<Product>
    ) {
    override fun toString(): String {
        return "UserWithProducts(user=$user, favoritesProduct=$products)"
    }
}