package com.yin.mvvmdemo.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "like")
class Like(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var pro_id: Long = 0,
    var user_id: Long = 0

) {
    override fun toString(): String {
        return "Like(id='$id', pro_id='$pro_id', user_id=$user_id)"
    }
}