package com.yin.mvvmdemo.fragments.main

import android.os.Bundle
import android.util.Log
import android.util.TimeUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.yin.mvvmdemo.R
import com.yin.mvvmdemo.data.TwoWayData
import com.yin.mvvmdemo.databinding.FragmentTwoWayBinding
import com.yin.mvvmdemo.util.TimeUitl

class TwoWayFragment: Fragment() {

    var twoWayData: TwoWayData = TwoWayData()
    lateinit var binding: FragmentTwoWayBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_two_way, container, false)
        binding.twowayfragment = this
        binding.twoway = twoWayData
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    fun onPrint(view: View){
        twoWayData.currentTime = System.currentTimeMillis()
        Log.w("scj", "onPrint-->" + twoWayData.currentTime + " " + TimeUitl.stampToTime(twoWayData.currentTime))
    }
}