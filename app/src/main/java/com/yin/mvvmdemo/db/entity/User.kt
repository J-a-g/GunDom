package com.yin.mvvmdemo.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
class User {
    @PrimaryKey(autoGenerate = true)
    var user_id: Long = 0

    @ColumnInfo(name = "tb_username")
    var username: String? = null

    @ColumnInfo(name = "tb_password")
    var password: String? = null
    var email: String? = null
    var login: Boolean? = false

    override fun toString(): String {
        return "UserEntity(id=$user_id, username=$username, password=$password, email=$email, login=$login)"
    }

}