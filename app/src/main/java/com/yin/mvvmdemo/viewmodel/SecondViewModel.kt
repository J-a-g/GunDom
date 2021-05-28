package com.yin.mvvmdemo.viewmodel

import android.util.Log
import androidx.databinding.ObservableField
import com.yin.mvvmdemo.activity.SecondActivity

class SecondViewModel(activity: SecondActivity) {
    var mActivity: SecondActivity = activity
    val name: ObservableField<String> = ObservableField<String>()

    init {
        name.set("scuhengjian")
    }

    fun initView(){

    }
}