package com.yin.mvvmdemo.viewmodel

import androidx.lifecycle.ViewModel
import com.yin.mvvmdemo.BasicApp
import com.yin.mvvmdemo.db.DataRepository

class FavoritesViewModel: ViewModel() {

    var products = DataRepository.getInstance()?.getFavoritesProducts(BasicApp.currentUser.user_id)
}