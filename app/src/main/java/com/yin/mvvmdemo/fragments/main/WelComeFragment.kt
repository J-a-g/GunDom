package com.yin.mvvmdemo.fragments.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.yin.mvvmdemo.R

class WelComeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_welcome, container, false)
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
        view.findViewById<Button>(R.id.btn_data_binding_basic).setOnClickListener {
            findNavController().navigate(R.id.action_welcome_to_basic, null, options)
        }

        view.findViewById<Button>(R.id.btn_data_binding_two_way).setOnClickListener {
            findNavController().navigate(R.id.action_welcome_to_two_way, null)
        }
    }
}