package com.yin.mvvmdemo.step2

import android.util.Log
import androidx.lifecycle.LiveData

class MyElapsedTime : LiveData<Long>() {

    fun onPostValue(v: Long){
        postValue(v)
    }

    fun onValue(v: Long){
        value = v
    }

    override fun onActive() {
        super.onActive()
        Log.w("scj", "MyElapsedTime onActive ")
    }

    override fun onInactive() {
        super.onInactive()
        Log.w("scj", "MyElapsedTime onInactive ")
    }
}
