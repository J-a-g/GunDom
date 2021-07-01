package com.yin.mvvmdemo.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yin.mvvmdemo.databinding.ItemProductBinding
import com.yin.mvvmdemo.db.entity.Product

class Product2Adapter(private val products: Array<Product>) :
    RecyclerView.Adapter<Product2Adapter.ProductViewHold>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHold {
        return ProductViewHold(
            ItemProductBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    class ProductViewHold(private val binding: ItemProductBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.clickListener = View.OnClickListener {
                Log.w("scj", "product->" + binding.product.toString())
            }
        }

        fun bind(product: Product) {
            binding.product = product
            binding.executePendingBindings()
        }
    }

    override fun onBindViewHolder(holder: ProductViewHold, position: Int) {
        Log.w("scj", "ProductAdapter onBindViewHolder...")
        val product = products.get(position)
        holder.bind(product)
    }

    override fun getItemCount(): Int {
        return products.size
    }

}