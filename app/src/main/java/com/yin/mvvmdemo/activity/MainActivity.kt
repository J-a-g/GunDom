package com.yin.mvvmdemo.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.yin.mvvmdemo.R
import com.yin.mvvmdemo.adapter.NewsAdapter
import com.yin.mvvmdemo.databinding.ActivityMain1Binding
import com.yin.mvvmdemo.model.News
import com.yin.mvvmdemo.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    companion object {
        val TAG: String = "scj"
    }

    var activityMain1Binding: ActivityMain1Binding? = null
    var mainViewModel: MainViewModel? = null
    var newsAdapter: NewsAdapter<News>? = null
    var newslist: MutableList<News>? = ArrayList<News>();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //设置dataBinding, viewModel
        activityMain1Binding = DataBindingUtil.setContentView(this,
            R.layout.activity_main1
        )
        mainViewModel = MainViewModel(this)
        activityMain1Binding?.viewModel = mainViewModel

        // 初始化RecyclerView
        val layoutManager = LinearLayoutManager(this)
        activityMain1Binding?.recyclerView?.layoutManager = layoutManager
        newsAdapter = newslist?.let { NewsAdapter<News>(this, it) }
        activityMain1Binding?.recyclerView?.adapter = newsAdapter
        mainViewModel?.loadNews()

//        activityMain1Binding?.btn?.setOnClickListener(View.OnClickListener {
//            startActivity(Intent(this, ThirdActivity::class.java))
//        })
//        setContentView(R.layout.activity_main)
//        tv.setOnClickListener(View.OnClickListener {
//            Log.w("scj", "onclick")
//
//        })
    }
}
