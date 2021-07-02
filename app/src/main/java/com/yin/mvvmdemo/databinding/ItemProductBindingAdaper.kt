package com.yin.mvvmdemo.databinding

import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.yin.mvvmdemo.R

object ItemProductBindingAdaper {
    @BindingAdapter("imageUrl")
    @JvmStatic
    fun bindImageUrl(view: ImageView, imageUrl: String){
        if(!imageUrl.isNullOrEmpty()){
            Log.w("scj", "imageUrl->" + imageUrl)
            Glide.with(view.context)
                .asBitmap()
                .load(imageUrl)
                .placeholder(R.drawable.glide_placeholder)
                .centerCrop()
                .into(view)
        }

    }
}