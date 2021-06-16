package com.yin.mvvmdemo.step3

import android.content.Context
import android.location.LocationListener
import androidx.lifecycle.LifecycleOwner

object BoundLocationManager {

    fun bindLocationListenerIn(
        lifecycleOwner: LifecycleOwner,
        listener: LocationListener,
        mcontext: Context
    ): BoundLocationListener {
        MyListener(lifecycleOwner)
        return BoundLocationListener(lifecycleOwner, listener, mcontext)
    }
}