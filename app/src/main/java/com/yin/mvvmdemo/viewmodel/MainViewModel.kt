package com.yin.mvvmdemo.viewmodel

import android.util.Log
import com.yin.mvvmdemo.activity.MainActivity
import com.yin.mvvmdemo.model.Feed
import com.yin.mvvmdemo.model.News
import com.yin.mvvmdemo.net.interfaces.LoadListener

class MainViewModel(activity: MainActivity) {
    var mActivity: MainActivity? = activity

    fun loadNews(){
        val feed = Feed()
        feed.loadData(object : LoadListener<News>{
            override fun loadSuccess(list: List<News>) {
                Log.w("scj", "loadSuccess :" + list.toString())
                mActivity?.newslist?.addAll(list)
                mActivity?.newsAdapter?.notifyDataSetChanged()
            }

            override fun loadFailure(t: Throwable) {
                Log.w("scj", "loadFailure")
                t.printStackTrace()
            }

        })
    }
}