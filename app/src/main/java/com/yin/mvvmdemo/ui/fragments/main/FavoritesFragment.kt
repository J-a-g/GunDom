package com.yin.mvvmdemo.ui.fragments.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.yin.mvvmdemo.R
import com.yin.mvvmdemo.databinding.FragmentFavoritesBinding
import com.yin.mvvmdemo.ui.adapter.FavoritesAdapter
import com.yin.mvvmdemo.viewmodel.FavoritesViewModel
import dagger.hilt.android.AndroidEntryPoint

//收藏
@AndroidEntryPoint
class FavoritesFragment : Fragment() {

    private val viewModel: FavoritesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.w("scj", "FavoritesFragment onCreateView")
        val binding: FragmentFavoritesBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_favorites, container, false)
        binding.lifecycleOwner = this
        val adapter = FavoritesAdapter()
        binding.favoritesListRecyclerView.adapter = adapter
        viewModel.products?.observe(viewLifecycleOwner, {
            it?.let {
                Log.w("scj", "products 更新回调 : " + it)
                if (it.isNotEmpty()) {
                    adapter.submitList(it[0].products)
                }
            }
        })


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.w("scj", "FavoritesFragment onViewCreated")
    }


    override fun onResume() {
        super.onResume()
        Log.w("scj", "FavoritesFragment onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.w("scj", "FavoritesFragment onPause")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.w("scj", "FavoritesFragment onDestroy")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.w("scj", "FavoritesFragment onDestroyView")
    }

    override fun onDetach() {
        super.onDetach()
        Log.w("scj", "FavoritesFragment onDetach")
    }
}