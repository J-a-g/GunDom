package com.yin.mvvmdemo.util

import android.content.Context
import android.util.Log
import android.widget.Toast
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

object TimeUitl {

    fun test(context: Context) {
        val time: Long = System.currentTimeMillis()
        val timeStr: String = stampToTime(time)
        val result: Long = timeToStamp("su" + timeStr + "su")
        val n = 0
        if (result == n.toLong()) {
            Toast.makeText(context, "格式错误", Toast.LENGTH_SHORT).show()
        }
    }

    //时间戳转时间格式
    fun stampToTime(time: Long): String {
        val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        val sd: String = sdf.format(Date(time))
        return sd
    }

    //时间格式转时间戳
    fun timeToStamp(timers: String): Long {
        var result: Long = 0
        try {
            val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
            val d = sdf.parse(timers)
            result = d.time
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return result
    }

}