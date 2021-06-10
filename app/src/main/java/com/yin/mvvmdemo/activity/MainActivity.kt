package com.yin.mvvmdemo.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.yin.mvvmdemo.R
import com.yin.mvvmdemo.databinding.ActivityMain1Binding
import com.yin.mvvmdemo.step1.ChronometerViewModel
import com.yin.mvvmdemo.step1.ViewModelActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMain1Binding =
            DataBindingUtil.setContentView(this, R.layout.activity_main1)
    }

    fun onClick(view: View){
        if(view.id == R.id.btn_step1){
            startActivity(Intent(this, ViewModelActivity::class.java))
        }
    }
}