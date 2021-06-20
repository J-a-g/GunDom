package com.yin.mvvmdemo.ui.fragments.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.yin.mvvmdemo.R
import com.yin.mvvmdemo.databinding.FragmentProductBinding

class ProductFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.w("scj", "ProductFragment onCreateView")
        val binding: FragmentProductBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_product, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.w("scj", "ProductFragment onViewCreated")
    }

    override fun onResume() {
        super.onResume()
        Log.w("scj", "ProductFragment onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.w("scj", "ProductFragment onPause")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.w("scj", "ProductFragment onDestroy")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.w("scj", "ProductFragment onDestroyView")
    }

    override fun onDetach() {
        super.onDetach()
        Log.w("scj", "ProductFragment onDetach")
    }
}