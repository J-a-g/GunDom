package com.yin.mvvmdemo.viewmodel

import androidx.lifecycle.ViewModel
import com.yin.mvvmdemo.db.DataRepository
import com.yin.mvvmdemo.db.entity.User

class LoginViewModel : ViewModel() {

    fun login(user: User, onLoginListener: OnLoginListener) {
        DataRepository.getInstance()?.loginUser(user)?.let { onLoginListener.onResult(it) }
    }

    interface OnLoginListener {
        fun onResult(result: Boolean)
    }
}