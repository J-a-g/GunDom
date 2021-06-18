package com.yin.mvvmdemo.util

import android.util.Log
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yin.mvvmdemo.ui.adapter.UserAdapter

object BindingAdapter {

    @BindingAdapter("setAdapter")
    @JvmStatic
    fun setAdapter(view: RecyclerView, adapter: UserAdapter){
        Log.w("scj", "setAdapter...")
//        view.setHasFixedSize(true)
        view.adapter = adapter

    }
}