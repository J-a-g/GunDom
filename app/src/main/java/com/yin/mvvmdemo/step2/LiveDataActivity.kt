package com.yin.mvvmdemo.step2

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.yin.mvvmdemo.R
import com.yin.mvvmdemo.databinding.ActivityLiveDataBinding


//如何实现？？
class LiveDataActivity : AppCompatActivity() {

    var binding: ActivityLiveDataBinding? = null
    var liveDataTimerViewModel: LiveDataTimerViewModel? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =
            DataBindingUtil.setContentView(this, R.layout.activity_live_data)

        liveDataTimerViewModel = ViewModelProvider(this).get(LiveDataTimerViewModel::class.java)

//        binding?.liveDataTimerViewModel = liveDataTimerViewModel
        subscribe()

    }

    fun subscribe() {
        val elapsedTimeObserver = Observer<Long> {
            Log.w("scj", "elapsedTimeObserver it---> " + it)
            val newText = it.toString() + "seconds elapsed"
            binding?.tvHelloWorld?.text = newText
        }
        liveDataTimerViewModel?.mElapsedTime?.observe(this, elapsedTimeObserver)

    }
}