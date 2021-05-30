package com.yin.mvvmdemo.fragments.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.yin.mvvmdemo.R
import com.yin.mvvmdemo.bean.User

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
        view.findViewById<Button>(R.id.btn_login).setOnClickListener {
//            findNavController().navigate(R.id.login, null, options)
            findNavController().navigate(R.id.login, null, options)
        }

//        view.findViewById<Button>(R.id.btn_register).setOnClickListener {
//            val action = WelComeFragmentDirections.actionWelcomeToRegister().setMyarg("suchengjian").setEMAIL("1090@qq.com")
//            findNavController().navigate(action)
//        }

        view.findViewById<Button>(R.id.btn_register).setOnClickListener {
            val bundle = Bundle()
            bundle.putString("name", "sudaqiang")
            bundle.putString("sex", "man")
            bundle.putParcelable("user", User("苏大强", "1", "60"))
            findNavController().navigate(R.id.action_welcome_to_register, bundle)
        }

//        view.findViewById<Button>(R.id.btn_register).setOnClickListener(
//            Navigation.createNavigateOnClickListener(R.id.action_welcome_to_register, null)
//        )
    }
}