package com.yin.mvvmdemo.viewmodel

import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.yin.mvvmdemo.BasicApp
import com.yin.mvvmdemo.db.DataRepository
import com.yin.mvvmdemo.db.entity.User

class RegistViewModel : ViewModel() {

    fun regist(user: User) {
        val result = DataRepository.getInstance()?.registUser(user)
        if (result != true) {
            Toast.makeText(BasicApp.instance, "邮箱或账号已存在!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(BasicApp.instance, "注册成功!", Toast.LENGTH_SHORT).show()
        }
    }
}