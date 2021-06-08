package com.yin.mvvmdemo.data

import android.util.Log
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.yin.mvvmdemo.BR

class TwoWayData : BaseObservable() {


    var click: Boolean = false
        @Bindable get() {
            Log.w("scj", "TwoWayData isClick get:" + field)
            return field
        }
        set(value: Boolean) {
            Log.w("scj", "TwoWayData isClick set :" + click + "--" + value)
            field = value
            notifyPropertyChanged(BR.click)
        }

    var currentTime: Long = System.currentTimeMillis()
        @Bindable get() {
            Log.w("scj", "currentTime get")
            return field
        }
        set(value) {
            Log.w("scj", "currentTime set")
            if (field != value) {
                field = value
                if (value > 0) {
                    notifyPropertyChanged(BR.currentTime)
                }
            }
        }

    private var numberOfSetsTotal = 5
    private var numberOfSetsElapsed = 0

    var numerOfTest: Array<Int> = emptyArray()
        @Bindable get() {
            Log.w("scj", "numerOfTest get Method")
            return arrayOf(numberOfSetsElapsed, numberOfSetsTotal, 8)
        }
        set(value: Array<Int>) {
            Log.w("scj", "numerOfTest set Method")
            Log.w("scj", "list size--> " + value.size)
            for ((index, e) in value.withIndex()) {
                Log.w("scj", "下标=$index----元素=$e")
            }
            val newTotal = value[1]
            val newElapse = value[0]
            if (newTotal == numerOfTest[1]) return // Break loop if there's no change
            // Only update if it doesn't affect the current exercise
            if (newTotal != 0 && newTotal > numberOfSetsElapsed) {
                field = value
                numberOfSetsTotal = newTotal
                numberOfSetsElapsed = newElapse
            }
            // Even if the input is empty, force a refresh of the view
            notifyPropertyChanged(BR.numerOfTest)
        }

    fun onChecked() {
        click = !click
        notifyPropertyChanged(BR.click)
        Log.w("scj", "list size--> " + numerOfTest.size)
//        for ((index, e) in numerOfTest.withIndex()) {
//            println("下标=$index----元素=$e")
//        }
    }
}