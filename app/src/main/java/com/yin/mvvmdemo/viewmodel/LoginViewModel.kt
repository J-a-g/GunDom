package com.yin.mvvmdemo.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.yin.mvvmdemo.BasicApp
import com.yin.mvvmdemo.db.entity.User
import com.yin.mvvmdemo.db.repositories.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {

    fun login(user: User, onLoginListener: OnLoginListener) {
        val currentUser: User? = userRepository.loginUser(user)
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