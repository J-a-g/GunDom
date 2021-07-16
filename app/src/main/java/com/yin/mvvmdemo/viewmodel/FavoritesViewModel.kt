package com.yin.mvvmdemo.viewmodel

import androidx.lifecycle.ViewModel
import com.yin.mvvmdemo.BasicApp
import com.yin.mvvmdemo.db.repositories.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(private val userRepository: UserRepository) :
    ViewModel() {

    var products = userRepository.getFavoritesProducts(BasicApp.currentUser.user_id)
}