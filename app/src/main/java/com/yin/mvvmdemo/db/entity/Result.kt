package com.yin.mvvmdemo.db.entity

import androidx.room.ColumnInfo

class Result(
    @ColumnInfo(name = "tb_username") val userName: String = "",
    @ColumnInfo(name = "pd_name") var name: String = "",
    @ColumnInfo(name = "pd_price") var price: Double = 0.0
) {

    override fun toString(): String {
        return "Result(userName='$userName', name='$name', price=$price)"
    }
}