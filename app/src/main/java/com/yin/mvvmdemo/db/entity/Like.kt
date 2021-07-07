package com.yin.mvvmdemo.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(primaryKeys = ["pd_id", "user_id"])
data class Like(
    val pd_id: Long,
    val user_id: Long

) {
    override fun toString(): String {
        return "Like(pd_id='$pd_id', user_id=$user_id)"
    }
}