package com.yin.mvvmdemo.step2

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModelWithLiveData: ViewModel() {

    var linkNumber: MutableLiveData<Int>? = null
        get() {
            if(field == null){
                field = MutableLiveData(0)
            }
            return field
        }

    fun addLinkedNumber(){
        linkNumber?.postValue(linkNumber?.value?.plus(1))
//        linkNumber?.value = (linkNumber?.value?.plus(1))
    }
}