package com.yin.mvvmdemo.ui.fragments.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.yin.mvvmdemo.R
import com.yin.mvvmdemo.databinding.FragmentProductBinding
import com.yin.mvvmdemo.ui.adapter.ProductAdapter
import com.yin.mvvmdemo.viewmodel.ProductViewModel

class ProductFragment : Fragment() {

    private val viewModel: ProductViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentProductBinding.inflate(inflater, container, false)
        binding.viewmodel = viewModel
//        context ?: return binding.root
        binding.lifecycleOwner = this// TODO 有疑问

        val adapter = ProductAdapter(onItemClickListener)
        binding.productListRecyclerView.adapter = adapter
        viewModel.products?.observe(viewLifecycleOwner, Observer {
            it?.let {
                Log.w("scj", "products 更新回调 : " + it)

                adapter.submitList(it)
            }
        })

        Log.w("scj", "products 更新回调 : " + viewModel.products?.value)
        return binding.root
    }

    private val onItemClickListener = object : ProductAdapter.OnItemClickListener {
        override fun onItemClick(view: View, position: Int) {
            if(view.id == R.id.tv_like){
                Log.w("scj", "position ->" + position + " 被点赞")
                viewModel.onLike(position)
            }else {
                viewModel.onclickItem(position)
            }
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


    /**************生命周期相关************/

    override fun onResume() {
        super.onResume()
        Log.w("scj", "ProductFragment onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.w("scj", "ProductFragment onPause")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.w("scj", "ProductFragment onDestroy")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.w("scj", "ProductFragment onDestroyView")
    }

    override fun onDetach() {
        super.onDetach()
        Log.w("scj", "ProductFragment onDetach")
    }
}