package com.yin.mvvmdemo.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
class UserEntity {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    @ColumnInfo(name = "tb_username")
    var username: String? = null

    @ColumnInfo(name = "tb_password")
    var password: String? = null
    var email: String? = null
    var login: Boolean? = false

    override fun toString(): String {
        return "UserEntity(id=$id, username=$username, password=$password, email=$email, login=$login)"
    }

}