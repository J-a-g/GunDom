package com.yin.mvvmdemo

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.yin.mvvmdemo.db.AppDatabase
import com.yin.mvvmdemo.db.DataRepository
import com.yin.mvvmdemo.db.entity.User
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BasicApp : Application() {
    companion object {
        lateinit var instance: Application
        lateinit var currentUser: User
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}