package com.yin.mvvmdemo.activity

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import com.yin.mvvmdemo.R
import com.yin.mvvmdemo.data.ObservableFieldProfile
import com.yin.mvvmdemo.databinding.ActivityBasicBinding

//基础绑定功能
//绑定适配器 -对应xml中的 ProgressBar的app:progressScaled
// https://developer.android.com/topic/libraries/data-binding/binding-adapters
//布局和绑定表达式-对应xml中的ImageView id=imageView
// https://developer.android.com/topic/libraries/data-binding/expressions
//导入其他类 https://developer.android.com/topic/libraries/data-binding/expressions#import-classes
//BindingMethods ??


class BasicActivity : AppCompatActivity() {

    val user: ObservableFieldProfile = ObservableFieldProfile(
        "大强",
        ObservableField("苏"),
        ObservableInt(0)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityBasicBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_basic)
        binding.user = user
        binding.basic = this

    }

    fun onLike(view: View) {
        user.lastName.set("孔")
        user.name = "雪蒙"
        user.likes.set(user.likes.get() + 1)
        Toast.makeText(this, "onLike", Toast.LENGTH_SHORT).show()
    }
}