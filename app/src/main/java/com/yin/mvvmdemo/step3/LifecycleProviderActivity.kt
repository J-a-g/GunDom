package com.yin.mvvmdemo.step3

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.databinding.DataBindingUtil
import com.yin.mvvmdemo.R
import com.yin.mvvmdemo.databinding.ActivityLifecycleBinding

//在Activity生命周期onRsume时注册，onPause时反注册，依赖lifecycleOwner

class LifecycleProviderActivity : AppCompatActivity() {

    val REQUEST_LOCATION_PERMISSION_CODE: Int = 1
    var binding: ActivityLifecycleBinding? = null
    var mGpsListener: LocationListener? = null

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (grantResults.size > 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED
            && grantResults[1] == PackageManager.PERMISSION_GRANTED
        ) {
            bindLocationListener()
        } else {
            Toast.makeText(this, "This sample requires Location access", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =
            DataBindingUtil.setContentView(this, R.layout.activity_lifecycle)
        mGpsListener = MyLocationListener(this, binding!!)
        Log.w("scj", "Activity onCreate")
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
            && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ),
                REQUEST_LOCATION_PERMISSION_CODE
            )
        } else {
            bindLocationListener()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.w("scj", "Activity onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.w("scj", "Activity onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.w("scj", "Activity onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.w("scj", "Activity onStop")
    }

    fun bindLocationListener() {
        BoundLocationManager.bindLocationListenerIn(this, mGpsListener!!, application)
    }

    class MyLocationListener(val context: Context, var binding: ActivityLifecycleBinding) :
        LocationListener {

        override fun onLocationChanged(location: Location?) {
            binding.tvLocation.text = "" + location?.getLatitude() + ", " + location?.getLongitude()
        }

        override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {
        }

        override fun onProviderEnabled(provider: String?) {
            Toast.makeText(
                context,
                "Provider enabled: " + provider, Toast.LENGTH_SHORT
            ).show();
        }

        override fun onProviderDisabled(provider: String?) {
        }

    }
}