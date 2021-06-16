package com.yin.mvvmdemo.step1

import android.os.SystemClock
import android.util.Log
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.ObservableLong
import androidx.lifecycle.ViewModel

class ChronometerViewModel : ViewModel() {
    //ViewModel的作用保持

    var startTime: ObservableLong? = null

    fun startTime(){
        val n = 0
        if(startTime?.get() == n.toLong() || startTime == null){
            startTime = ObservableLong(SystemClock.elapsedRealtime())
        }
    }

    override fun onCleared() {
        super.onCleared()
    }
}