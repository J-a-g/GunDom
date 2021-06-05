package com.yin.mvvmdemo.util

import android.util.Log
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter

object BindingAdapter {

    @BindingAdapter(value = ["app:progressScaled", "android:max"], requireAll = true)
    @JvmStatic fun setProgress(progressBar: ProgressBar, likes: Int, max: Int) {
        Log.w("scj", "setProgress...")
        progressBar.progress = (likes * max / 5).coerceAtMost(max)
    }
}