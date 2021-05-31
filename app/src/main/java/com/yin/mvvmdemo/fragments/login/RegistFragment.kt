package com.yin.mvvmdemo.fragments.login

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.yin.mvvmdemo.R
import com.yin.mvvmdemo.bean.User

class RegistFragment : Fragment() {

    lateinit var tv: TextView
    lateinit var etEmail: EditText

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_regist, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.tv_cancel).setOnClickListener {
            Navigation.findNavController(it).navigateUp()
        }
        view.findViewById<Button>(R.id.btn_sign_up).setOnClickListener {
            findNavController().navigate(R.id.action_register_to_register_next, null)
        }

        tv = view.findViewById(R.id.tv)
        etEmail = view.findViewById(R.id.et_email)

        val safeArgs: RegistFragmentArgs by navArgs()
        val text = safeArgs.email + ":" + safeArgs.myarg
        tv.setText(text)
        etEmail.setText(safeArgs.email)

        val name = arguments?.getString("name")
        val sex = arguments?.getString("sex")
        val user: User? = arguments?.getParcelable<User>("user")
        Log.w("scj", "===>" + name + ":" + sex + ":" + user.toString())
    }
}