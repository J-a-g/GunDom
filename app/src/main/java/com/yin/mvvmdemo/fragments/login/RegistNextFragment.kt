package com.yin.mvvmdemo.fragments.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.yin.mvvmdemo.R
import com.yin.mvvmdemo.activity.MainActivity

class RegistNextFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_regist_next, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.tv_cancel).setOnClickListener {
            Navigation.findNavController(it).navigateUp()
        }

        view.findViewById<Button>(R.id.btn_finish_sign_up).setOnClickListener {
            findNavController().navigate(R.id.action_regist_next_to_welcome, null)
        }

        view.findViewById<Button>(R.id.btn_sign_up).setOnClickListener {
            context?.startActivity(Intent(context, MainActivity::class.java))
        }


    }
}