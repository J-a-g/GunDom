package com.yin.mvvmdemo.ui.fragments.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.yin.mvvmdemo.R
import com.yin.mvvmdemo.databinding.FragmentFavoritesBinding
import com.yin.mvvmdemo.databinding.FragmentSettingBinding

//收藏
class FavoritesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.w("scj", "FavoritesFragment onCreateView")
        val binding: FragmentFavoritesBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_favorites, container, false)
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