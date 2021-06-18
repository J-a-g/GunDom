package com.yin.mvvmdemo.viewmodel

import androidx.lifecycle.MutableLiveData

class User(private val names: String) {
    var name: MutableLiveData<String> = MutableLiveData()
    var imageUrl: MutableLiveData<String> = MutableLiveData()
    init {
        name.value = names
        imageUrl.value = names + " hello world"
    }

    override fun toString(): String {
        return "User(name=${name.value}, imageUrl=${imageUrl.value})"
    }


}