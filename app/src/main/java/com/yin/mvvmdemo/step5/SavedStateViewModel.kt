package com.yin.mvvmdemo.step5

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class SavedStateViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {

    val KEY_NAME: String = "name"
    val name: LiveData<String> = savedStateHandle.getLiveData(KEY_NAME)

    fun setName(name: String) {
        savedStateHandle[KEY_NAME] = name
    }
}