package com.yin.mvvmdemo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    val textContent : MutableLiveData<String> = MutableLiveData("苏大强")

    override fun onCleared() {
        super.onCleared()
    }
}