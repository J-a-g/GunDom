package com.yin.mvvmdemo.step4

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SeekBarViewModel : ViewModel() {

    val seekbarValue: MutableLiveData<Int> = MutableLiveData()
}