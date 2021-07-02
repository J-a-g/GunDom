package com.yin.mvvmdemo

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.yin.mvvmdemo.db.AppDatabase
import com.yin.mvvmdemo.db.DataRepository

class BasicApp : Application() {
    companion object {
        lateinit var instance: Application
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}