package com.yin.mvvmdemo.step2

import android.os.SystemClock
import android.util.Log
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class LiveDataTimerViewModel : ViewModel() {

    val ONE_SECOND: Long = 1000
    var mInitialTime: Long = 0
    var timer: Timer? = null

    val mElapsedTime: MutableLiveData<Long> = MutableLiveData()//LiveData
    val myTime: MyElapsedTime = MyElapsedTime() //LiveData
    val liveDataMerger = MediatorLiveData<Long>() //MediatorLiveData

    init {
        mInitialTime = SystemClock.elapsedRealtime()
        timer = Timer()

        liveDataMerger.addSource(mElapsedTime, androidx.lifecycle.Observer {
            liveDataMerger.value = it
        })
        liveDataMerger.addSource(myTime, androidx.lifecycle.Observer {
            mInitialTime = SystemClock.elapsedRealtime()
            liveDataMerger.value = it
        })

        timer?.scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                val newValue = (SystemClock.elapsedRealtime() - mInitialTime) / 1000
                Log.w("scj", "newValue-->" + newValue + " mElapsedTime ->" + mElapsedTime.value)
                mElapsedTime.postValue(newValue)
            }
        }, ONE_SECOND, ONE_SECOND)
    }

    override fun onCleared() {
        super.onCleared()
        timer?.cancel()
    }
}