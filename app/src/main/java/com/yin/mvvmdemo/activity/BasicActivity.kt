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
//绑定适配器 -对应xml中的 ProgressBar的app:progressScaled 提供自定义逻辑??
// https://developer.android.com/topic/libraries/data-binding/binding-adapters
//布局和绑定表达式-对应xml中的ImageView id=imageView
// https://developer.android.com/topic/libraries/data-binding/expressions
//导入其他类 https://developer.android.com/topic/libraries/data-binding/expressions#import-classes
//BindingMethods ?? 指定自定义方法名称
//双向数据绑定是指 源数据 和 UI 之间是互相影响的。其一发生变化另一个也会跟着变化。源数据可监听
//@={} 表示法

//BindingConversion这个感觉不太好用


//自定义加载图片 绑定适配器（属性）写着BindingAdapter
//自定义一个icon切换 绑定适配器（属性）写在BindingAdapter

class BasicActivity : AppCompatActivity() {

    val user: ObservableFieldProfile = ObservableFieldProfile(
        "大强",
        ObservableField("苏"),
        ObservableInt(0),
        ObservableField("http://192.168.1.104/TestDemo2/img_test.jpg")
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