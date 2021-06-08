package com.yin.mvvmdemo.data

import android.util.Log
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.yin.mvvmdemo.BR

class TwoWayData : BaseObservable() {

    var click: Boolean = false
        @Bindable get() {
            Log.w("scj", "click get")
            return field
        }
        set(value: Boolean) {
            Log.w("scj", "click set")
            field = value
            notifyPropertyChanged(BR.click)
        }

    var currentTime: Long = System.currentTimeMillis()
        @Bindable get() {
            return field
        }
        set(value) {
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