package com.yin.mvvmdemo.databinding

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.yin.mvvmdemo.R

object ItemProductBindingAdaper {
    @BindingAdapter("imageUrl")
    @JvmStatic
    fun bindImageUrl(view: ImageView, imageUrl: String) {
        if (!imageUrl.isNullOrEmpty()) {
            Log.w("scj", "imageUrl->" + imageUrl)
            Glide.with(view.context)
                .asBitmap()
                .load(imageUrl)
                .placeholder(R.drawable.glide_placeholder)
                .centerCrop()
                .into(view)
        }
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    @BindingAdapter("binddrawableEnd")
    @JvmStatic
    fun binddrawableEnd(view: TextView, like: Int) {
        val drawable: Drawable = if (like == 0) {
            view.context.resources.getDrawable(R.drawable.ic_baseline_favorite_border_24)
        } else {
            view.context.resources.getDrawable(R.drawable.ic_baseline_favorite_24)
        }
        drawable.setBounds(0, 0, drawable.minimumWidth, drawable.minimumHeight)
        view.setCompoundDrawables(null, null, drawable, null)
        view.text = ""  //like.toString()
    }
}