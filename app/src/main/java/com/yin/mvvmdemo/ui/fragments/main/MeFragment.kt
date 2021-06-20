package com.yin.mvvmdemo.ui.fragments.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.yin.mvvmdemo.R
import com.yin.mvvmdemo.databinding.FragmentMeBinding
import com.yin.mvvmdemo.databinding.FragmentSettingBinding
import com.yin.mvvmdemo.ui.fragments.login.WelComeFragmentDirections

class MeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.w("scj", "MeFragment onCreateView")
        val binding: FragmentMeBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_me, container, false)
        binding.fragment = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.w("scj", "MeFragment onViewCreated")
    }

    override fun onResume() {
        super.onResume()
        Log.w("scj", "MeFragment onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.w("scj", "MeFragment onPause")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.w("scj", "MeFragment onDestroy")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.w("scj", "MeFragment onDestroyView")
    }

    override fun onDetach() {
        super.onDetach()
        Log.w("scj", "MeFragment onDetach")
    }

    fun onClick(view: View) {
        Log.w("scj", "MeFragment onclick")
        view.findNavController().navigate(HomeViewPageFragmentDirections.actionMeToSetting())
    }
}