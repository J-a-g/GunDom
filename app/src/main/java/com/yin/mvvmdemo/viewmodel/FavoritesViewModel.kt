package com.yin.mvvmdemo.viewmodel

import androidx.lifecycle.ViewModel
import com.yin.mvvmdemo.db.DataRepository

class FavoritesViewModel: ViewModel() {

    var products = DataRepository.getInstance()?.queryProduct()
}