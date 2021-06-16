package com.yin.mvvmdemo.step3

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.LocationListener
import android.location.LocationManager
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent

class BoundLocationListener(
    lifecycleOwner: LifecycleOwner,
    listener: LocationListener,
    mcontext: Context
) : LifecycleObserver {

    var locationManager: LocationManager? = null
    var context: Context? = null
    var listener: LocationListener? = null

    init {
        this.context = mcontext
        this.listener = listener
        lifecycleOwner.lifecycle.addObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun addLocationListener() {
        Log.w("scj", "ON_RESUME")
        locationManager = context?.getSystemService(Context.LOCATION_SERVICE) as LocationManager?

        if (context?.let {
                ActivityCompat.checkSelfPermission(
                    it,
                    Manifest.permission.ACCESS_FINE_LOCATION
                )
            } != PackageManager.PERMISSION_GRANTED && context?.let {
                ActivityCompat.checkSelfPermission(
                    it,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                )
            } != PackageManager.PERMISSION_GRANTED
        ) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return
        }
        locationManager?.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0.0f, listener)
        Log.d("scj", "Listener added")

        val lastLocation = locationManager?.getLastKnownLocation(LocationManager.GPS_PROVIDER)
        if(lastLocation != null){
            listener?.onLocationChanged(lastLocation)
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun removeLocationListener(){
        Log.w("scj", "ON_PAUSE")
        if(locationManager == null){
            return
        }
        locationManager?.removeUpdates(listener)
        locationManager = null

        Log.w("scj", "removeLocationListener")
    }
}