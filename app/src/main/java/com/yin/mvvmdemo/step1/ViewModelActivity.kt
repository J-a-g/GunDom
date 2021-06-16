package com.yin.mvvmdemo.step1

import android.os.Bundle
import android.os.SystemClock
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableLong
import androidx.lifecycle.ViewModelProvider
import com.yin.mvvmdemo.R
import com.yin.mvvmdemo.databinding.ActivityViewModelBinding

class ViewModelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityViewModelBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_view_model)
        val chronometerViewModel = ViewModelProvider(this).get(ChronometerViewModel::class.java)
        binding.chronometerviewmodel = chronometerViewModel
        chronometerViewModel.startTime()
    }
}