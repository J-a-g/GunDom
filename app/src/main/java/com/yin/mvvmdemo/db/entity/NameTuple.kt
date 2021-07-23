package com.yin.mvvmdemo.db.entity

import androidx.room.ColumnInfo

data class NameTuple(
    @ColumnInfo(name = "pd_name") val name: String?,
    @ColumnInfo(name = "pd_price") val price: Double?
) {
}