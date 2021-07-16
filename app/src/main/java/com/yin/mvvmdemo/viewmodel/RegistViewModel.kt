package com.yin.mvvmdemo.viewmodel

import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.yin.mvvmdemo.BasicApp
import com.yin.mvvmdemo.db.entity.User
import com.yin.mvvmdemo.db.repositories.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegistViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {

    fun regist(user: User) {
        val result = userRepository.registUser(user)
        if (!result) {
            Toast.makeText(BasicApp.instance, "邮箱或账号已存在!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(BasicApp.instance, "注册成功!", Toast.LENGTH_SHORT).show()
        }
    }
}