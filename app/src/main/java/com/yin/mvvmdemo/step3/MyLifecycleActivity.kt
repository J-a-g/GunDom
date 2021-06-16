package com.yin.mvvmdemo.step3

import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import com.yin.mvvmdemo.R
import com.yin.mvvmdemo.databinding.ActivityLifecycleBinding

//实现自定义 LifecycleOwner
class MyLifecycleActivity : Activity(), LifecycleOwner {

    private lateinit var lifecycleRegistry: LifecycleRegistry

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityLifecycleBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_lifecycle)

        lifecycleRegistry = LifecycleRegistry(this)
        MyListener(this)
    }

    override fun getLifecycle(): Lifecycle {
        return lifecycleRegistry
    }
}