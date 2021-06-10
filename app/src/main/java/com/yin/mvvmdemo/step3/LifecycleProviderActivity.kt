package com.yin.mvvmdemo.step3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.yin.mvvmdemo.R
import com.yin.mvvmdemo.databinding.ActivityLifecycleBinding

class LifecycleProviderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityLifecycleBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_lifecycle)
    }
}