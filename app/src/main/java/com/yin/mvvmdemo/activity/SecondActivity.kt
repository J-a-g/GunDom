package com.yin.mvvmdemo.activity

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.setContentView
import com.yin.mvvmdemo.R
import com.yin.mvvmdemo.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    var secondActivity: ActivitySecondBinding? = null

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        secondActivity = setContentView(this, R.layout.activity_second)


    }
}