package com.yin.mvvmdemo.step2

import android.os.SystemClock
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.sql.Time
import java.util.*

class LiveDataTimerViewModel: ViewModel() {


    val ONE_SECOND: Long = 1000

    var mInitialTime: Long = 0
    var timer : Timer? = null

    val mElapsedTime: MutableLiveData<Long> = MutableLiveData()

    init {
        mInitialTime =SystemClock.elapsedRealtime()
        timer = Timer()

        timer?.scheduleAtFixedRate(object : TimerTask(){
            override fun run() {
                val newValue = (SystemClock.elapsedRealtime() - mInitialTime) / 1000
                Log.w("scj", "newValue-->" + newValue + " mElapsedTime ->" + mElapsedTime.value)
                mElapsedTime.postValue(newValue)
            }
        }, ONE_SECOND, ONE_SECOND)
    }

    override fun onCleared() {
        Log.w("scj", "onCleared")
        super.onCleared()
        timer?.cancel()
    }
}