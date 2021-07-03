package com.yin.mvvmdemo.databinding

import android.util.Log
import androidx.databinding.BindingConversion

object BindingConverters {
    @JvmStatic fun isEnable(like: Int): Boolean {
        Log.w("scj", "isEnable")
        return like != 0
    }


    //TODO 有疑问
//    @BindingConversion //加了这个有什么区别
//    @JvmStatic fun isZero22(number: Int): Boolean {
//        Log.w("scj", "isZero")
//        return number == 0
//    }
}