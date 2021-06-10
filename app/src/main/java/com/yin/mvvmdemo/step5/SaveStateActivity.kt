package com.yin.mvvmdemo.step5

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.yin.mvvmdemo.R
import com.yin.mvvmdemo.databinding.ActivitySaveStateBinding

class SaveStateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivitySaveStateBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_save_state)
    }
}