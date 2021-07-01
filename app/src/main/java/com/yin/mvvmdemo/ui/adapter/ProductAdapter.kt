package com.yin.mvvmdemo.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yin.mvvmdemo.databinding.ItemProductBinding
import com.yin.mvvmdemo.db.entity.Product

class ProductAdapter(private val onItemClickListener: OnItemClickListener) :
    ListAdapter<Product, RecyclerView.ViewHolder>(ProductDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ProductViewHold(
            ItemProductBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Log.w("scj", "ProductAdapter onBindViewHolder : " + position)
        val product = getItem(position)

        (holder as ProductViewHold).bind(product, onItemClickListener)
    }

    class ProductViewHold(private val binding: ItemProductBinding) :
        RecyclerView.ViewHolder(binding.root) {

        lateinit var listener: OnItemClickListener

        init {
            binding.setClickListener {
                listener.onItemClick(position = position)
            }
        }

        fun bind(product: Product, onItemClickListener: OnItemClickListener) {
            binding.product = product
            binding.executePendingBindings()
            listener = onItemClickListener
        }
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

}

private class ProductDiffCallback : DiffUtil.ItemCallback<Product>() {


    override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem == newItem
    }
}