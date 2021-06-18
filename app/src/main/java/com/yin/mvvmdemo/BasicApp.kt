package com.yin.mvvmdemo

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.yin.mvvmdemo.db.AppDatabase
import com.yin.mvvmdemo.db.DataRepository

class BasicApp : Application() {


    override fun onCreate() {
        super.onCreate()
    }

//    fun getDatabase() = AppDatabase.getInstance(this)

    fun getDataRepository() = AppDatabase.getInstance(this)?.let { DataRepository.getInstance(it) }

}