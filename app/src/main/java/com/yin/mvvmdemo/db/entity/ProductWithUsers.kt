package com.yin.mvvmdemo.db.entity

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

class ProductWithUsers(
    @Embedded
    val product: Product,
    @Relation(
        parentColumn = "pd_id",
        entityColumn = "user_id",
        associateBy = Junction(Like::class)
    )
    val users: List<User>

) {
    override fun toString(): String {
        return "ProductWithUsers(product=$product, users=$users)"
    }
}