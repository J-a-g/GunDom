package com.yin.mvvmdemo.util

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener
import androidx.databinding.InverseMethod
import java.util.regex.Pattern

object MyEditDateTextBindingAdapter {

    @BindingAdapter("textDate")
    @JvmStatic
    fun setTextDate(view: EditText, value: String) {
        Log.w("suchengjian", "setTextDate")
        view.setText(value)
    }

    @InverseBindingAdapter(attribute = "textDate")
    @JvmStatic
    fun getTextDate(view: EditText): String {
        Log.w("suchengjian", "getTextDate")
        return view.text.toString()
    }

    @BindingAdapter("textDateAttrChanged")
    @JvmStatic
    fun setListener(view: EditText, listener: InverseBindingListener?) {
        Log.w("suchengjian", "setListener")
//        listener?.onChange()
        view.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                Log.w("scj", "afterTextChanged..." + s.toString())
                val regex =
                    "[0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}:[0-9]{2}" ////yyyy-MM-dd HH:mm:ss
                val btmp = Pattern.compile(regex).matcher(s.toString()).matches()
                if (btmp) {
                    Log.w("suchengjian", "listener?.onChange()")
                    listener?.onChange()
                }
            }

        })
    }

}

object MyTestConverters {

    //转换器：作用将Long转换成yyyy-MM-dd HH:mm:ss格式的字符串，设置到视图控件上
    @InverseMethod("stringToLong")
    @JvmStatic
    fun longToString(context: Context, currentTime: Long): String {
        Log.w("suchengjian", "longToString")
        return TimeUitl.stampToTime(currentTime)
    }

    //反向转换器：作用将yyyy-MM-dd HH:mm:ss格式的字符串转换成Long，设置到数据源上
    @JvmStatic
    fun stringToLong(context: Context, timers: String): Long {
        Log.w("suchengjian", "stringToLong")
        val result: Long = TimeUitl.timeToStamp(timers)
        val n: Int = 0
        if (result == n.toLong()) {
            Toast.makeText(context, "格式不正确", Toast.LENGTH_SHORT).show()
        }
        return result
    }
}