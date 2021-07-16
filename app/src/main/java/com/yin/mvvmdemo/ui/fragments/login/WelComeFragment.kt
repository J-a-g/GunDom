package com.yin.mvvmdemo.ui.fragments.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.yin.mvvmdemo.R
import com.yin.mvvmdemo.databinding.FragmentWelcomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WelComeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentWelcomeBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_welcome, container, false)
        binding.framgnet = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    fun onClick(view: View) {
        if (view.id == R.id.btn_login) {
            val direction = WelComeFragmentDirections.actionWelcomeToLogin("suchengjain")
            findNavController().navigate(direction)
//            findNavController().navigate(R.id.action_welcome_to_login)
        } else if (view.id == R.id.btn_regist) {
            findNavController().navigate(R.id.action_welcome_to_regist)
        }
    }
}