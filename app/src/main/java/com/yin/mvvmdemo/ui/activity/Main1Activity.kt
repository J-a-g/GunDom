package com.yin.mvvmdemo.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.yin.mvvmdemo.R
import com.yin.mvvmdemo.databinding.ActivityMain1Binding

class Main1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityMain1Binding>(this, R.layout.activity_main1)
    }
}