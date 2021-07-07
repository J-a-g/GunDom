package com.yin.mvvmdemo.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.yin.mvvmdemo.BasicApp
import com.yin.mvvmdemo.db.DataRepository
import com.yin.mvvmdemo.db.entity.User

class LoginViewModel : ViewModel() {

    fun login(user: User, onLoginListener: OnLoginListener) {
        val currentUser: User? = DataRepository.getInstance()?.loginUser(user)
        onLoginListener.onResult(currentUser)
        if (currentUser != null) {
            BasicApp.currentUser = currentUser
            Log.w("scj", "user:" + currentUser.toString())
        }
    }

    interface OnLoginListener {
        fun onResult(user: User?)
    }
}