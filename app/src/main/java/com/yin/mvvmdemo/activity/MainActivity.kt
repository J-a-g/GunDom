package com.yin.mvvmdemo.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.yin.mvvmdemo.R
import com.yin.mvvmdemo.adapter.UserAdapter
import com.yin.mvvmdemo.databinding.ActivityMainBinding
import com.yin.mvvmdemo.db.AppDatabase
import com.yin.mvvmdemo.viewmodel.MainViewModel
import com.yin.mvvmdemo.viewmodel.User

class MainActivity : AppCompatActivity() {

    private val mainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }
    private val binding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }

    private val userAdapter by lazy {
        Log.w("scj", "1111111111")
        val users: MutableList<User> = ArrayList()
        for (i in 0..100) {
            users.add(User("suc" + i))
        }
        UserAdapter(users)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.run {
            lifecycleOwner = this@MainActivity
            viewModel = mainViewModel
            adapter = userAdapter
        }

//        with(binding.recyclerView){
//            adapter = userAdapter
//        }
    }
}