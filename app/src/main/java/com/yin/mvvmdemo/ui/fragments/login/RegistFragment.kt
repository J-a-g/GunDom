package com.yin.mvvmdemo.ui.fragments.login

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.google.android.material.navigation.NavigationView
import com.yin.mvvmdemo.R
import com.yin.mvvmdemo.databinding.FragmentRegistBinding
import com.yin.mvvmdemo.db.entity.UserEntity
import com.yin.mvvmdemo.viewmodel.RegistViewModel

class RegistFragment : Fragment() {

    private val registViewModel by lazy {
        Log.w("scj", "1111111111")
        ViewModelProvider(this).get(RegistViewModel::class.java)
    }

    private var binding: FragmentRegistBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_regist, container, false)

        binding?.fragment = this
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    fun onClick(view: View) {
        if (view.id == R.id.tv_cancel) {
            Navigation.findNavController(view).navigateUp()
        } else if (view.id == R.id.btn_sign_up) {
            val user = UserEntity()
            user.username = binding?.etAccount?.text.toString().trim()
            user.email = binding?.etEmail?.text.toString().trim()
            user.password = binding?.etPassWorld?.text.toString().trim()
            user.login = true
            registViewModel.regist(user)
        }
    }
}