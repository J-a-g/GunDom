package com.yin.mvvmdemo.fragments.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import androidx.fragment.app.Fragment
import com.yin.mvvmdemo.R
import com.yin.mvvmdemo.data.ObservableFieldProfile
import com.yin.mvvmdemo.databinding.FragmentBasicBinding

class BasicFragment : Fragment() {


    val user: ObservableFieldProfile = ObservableFieldProfile(
        "大强",
        ObservableField("苏"),
        ObservableInt(0),
        ObservableField("https://gitee.com/jags/pictures/raw/master/images/img_test.jpg")
    )

    lateinit var binding: FragmentBasicBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_basic, container, false)
        binding.user = user
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}