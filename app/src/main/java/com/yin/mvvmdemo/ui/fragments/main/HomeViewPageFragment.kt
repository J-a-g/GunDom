package com.yin.mvvmdemo.ui.fragments.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.yin.mvvmdemo.BasicApp
import com.yin.mvvmdemo.R
import com.yin.mvvmdemo.databinding.FragmentViewPageBinding
import com.yin.mvvmdemo.db.DataRepository
import com.yin.mvvmdemo.ui.adapter.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeViewPageFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentViewPageBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_view_page, container, false)
        val viewPager = binding.viewPager
        val tabLayout = binding.tabs

        viewPager.adapter = HomePagerAdapter(this)

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.setIcon(getTabIcon(position))
            tab.text = getTabTitle(position)
        }.attach()

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun getTabIcon(position: Int): Int {
        return when (position) {
            PRODUCT_PAGE_INDEX -> R.drawable.ic_baseline_home_24
            FAVORITE_PAGE_INDEX -> R.drawable.ic_baseline_favorite_24
//            ME_PAGE_INDEX -> R.drawable.ic_baseline_person_24
            else -> throw IndexOutOfBoundsException()
        }
    }

    private fun getTabTitle(position: Int): String? {
        return when (position) {
            PRODUCT_PAGE_INDEX -> getString(R.string.product)
            FAVORITE_PAGE_INDEX -> getString(R.string.favorite)
//            ME_PAGE_INDEX -> getString(R.string.me)
            else -> null
        }
    }
}