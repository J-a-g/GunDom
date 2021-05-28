package com.yin.mvvmdemo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.yin.mvvmdemo.R
import com.yin.mvvmdemo.databinding.ItemNewsBinding
import com.yin.mvvmdemo.model.News

class NewsAdapter<T>(val context: Context, val dataSet: List<T>) :
    RecyclerView.Adapter<NewsAdapter.MyViewHolder>() {

    class MyViewHolder(item: ItemNewsBinding) :
        RecyclerView.ViewHolder(item.root) {
        val itemNewsBinding:ItemNewsBinding = item
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemNewsBinding: ItemNewsBinding =
            DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_news, parent, false)
        return MyViewHolder(itemNewsBinding)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val news = dataSet.get(position) as News
        holder.itemNewsBinding.news = news
        holder.itemNewsBinding.root.setOnClickListener(View.OnClickListener {
            Toast.makeText(context, "点击：" + position, Toast.LENGTH_SHORT).show()
        })

    }
}