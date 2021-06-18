package com.yin.mvvmdemo.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.yin.mvvmdemo.db.DataRepository
import com.yin.mvvmdemo.db.entity.UserEntity

class RegistViewModel : ViewModel() {

    fun regist(user: UserEntity) {
        DataRepository.getInstance()?.insertUser(user)
    }
}