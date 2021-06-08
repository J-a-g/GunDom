package com.yin.mvvmdemo.util

import android.graphics.drawable.Drawable
import android.util.Log
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.yin.mvvmdemo.R

object BindingAdapter {

    @BindingAdapter(value = ["app:progressScaled", "android:max"], requireAll = true)
    @JvmStatic
    fun setProgress(progressBar: ProgressBar, likes: Int, max: Int) {
        Log.w("scj", "setProgress...")
        progressBar.progress = (likes * max / 5).coerceAtMost(max)
    }


    @BindingAdapter("url", "error")
    @JvmStatic
    fun loadImage(view: ImageView, url: String, error: Drawable) {
        Log.w("scj", "loadImage...")
        Glide.with(view).load(url).placeholder(error).into(view)
    }

    //方法的第一个参数是属性相关联的 View，第二个参数是属性的旧值，第三个参数是属性的新值。当一个自定义适配器只有一个属性，但有三个参数，且第二个和第三个参数类型一致时就会采用这种新旧值的规则。
    @BindingAdapter("imageUrl")
    @JvmStatic
    fun loadImageUrl(view: ImageView, oldUrl: String?, newUrl: String?) {
        Log.w("scj", "loadImageUrl oldUrl->" + oldUrl + " newUrl->" + newUrl)
        if (!newUrl.equals(oldUrl)) {
            Glide.with(view).load(newUrl).placeholder(R.drawable.ic_baseline_error_outline_24)
                .into(view)
        }
    }

}