package com.yin.mvvmdemo.step3

import android.os.SystemClock
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent

class MyListener(private val lifecycleOwner: LifecycleOwner) : LifecycleObserver {
    init {
        lifecycleOwner.lifecycle.addObserver(this)

        lifecycleOwner.lifecycle.removeObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onMyStart(){
        Thread {
            SystemClock.sleep(2000)
            if (lifecycleOwner.lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED)) {
                Log.w("scj", "onMyStart 111")
                //do Something
            }else{
                Log.w("scj", "onMyStart 222")
            }
        }.start()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onMyStop(){
        Log.w("scj", "onMyStop")
    }
}