package com.yin.mvvmdemo.model

import android.annotation.SuppressLint
import android.util.Log
import com.yin.mvvmdemo.net.NetWork
import com.yin.mvvmdemo.net.interfaces.LoadListener
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class Feed {
    private val has_more = false
    private val message: String? = null
    private val data: List<News>? = null
    override fun toString(): String {
        return "Feed(has_more=$has_more, message=$message, data=$data)"
    }

    @SuppressLint("CheckResult")
    fun loadData(loadListener: LoadListener<News>){
        NetWork.getApi()
            ?.getFeed()
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe({
                Log.w("scj", "feed-->" + it.toString())
                it.data?.let { it1 -> loadListener.loadSuccess(it1) }
            }, {
                it.printStackTrace()
                loadListener.loadFailure(it)
            })
    }

}