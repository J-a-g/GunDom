package com.yin.mvvmdemo.fragments.main

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.yin.mvvmdemo.R
import com.yin.mvvmdemo.activity.BasicActivity
import com.yin.mvvmdemo.databinding.FragmentWelcomeBinding

class WelComeFragment : Fragment() {

    lateinit var binding: FragmentWelcomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_welcome, container, false)
        binding.welcome = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val options = navOptions {
            anim {
                enter = R.anim.slide_in_right
                exit = R.anim.slide_out_left
                popEnter = R.anim.slide_in_left
                popExit = R.anim.slide_out_right
            }
        }
//        binding.btnDataBindingBasic.setOnClickListener {
//            findNavController().navigate(R.id.action_welcome_to_basic, null, options)
//        }

        binding.btnDataBindingTwoWay.setOnClickListener {
            findNavController().navigate(R.id.action_welcome_to_two_way, null)
        }

        binding.btnDataBindingBasicActivity.setOnClickListener {
            startActivity(Intent(activity, BasicActivity::class.java))
        }
    }

    fun onClickTest(view: View) {
        findNavController().navigate(R.id.action_welcome_to_basic, null)
    }
}