package com.yin.mvvmdemo.data

import android.util.Log
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.yin.mvvmdemo.BR

class TwoWayData : BaseObservable() {

    var click: Boolean = false
        @Bindable get() {
            return field
        }
        set(value: Boolean) {
            field = value
            notifyPropertyChanged(BR.click)
        }

    var currentTime: Long = System.currentTimeMillis()
        @Bindable get() {
            Log.w("suchengjian", "currentTime get")
            return field
        }
        set(value) {
            Log.w("suchengjian", "currentTime set")
            if (field != value) {
                field = value
                if (value > 0) {
                    notifyPropertyChanged(BR.currentTime)
                }
            }
        }

    fun onChecked() {
        click = !click
        notifyPropertyChanged(BR.click)
    }
}