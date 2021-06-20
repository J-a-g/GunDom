package com.yin.mvvmdemo.ui.fragments.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.yin.mvvmdemo.R
import com.yin.mvvmdemo.databinding.FragmentLoginBinding
import com.yin.mvvmdemo.db.entity.UserEntity
import com.yin.mvvmdemo.ui.activity.MainActivity
import com.yin.mvvmdemo.viewmodel.LoginViewModel

class LoginFragment : Fragment() {

    private val loginViewModel by lazy {
        ViewModelProvider(this).get(LoginViewModel::class.java)
    }

    private var binding: FragmentLoginBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        binding?.fragment = this
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    fun onClick(view: View) {
        if (view.id == R.id.tv_cancel) {
            Navigation.findNavController(view).navigateUp()
        } else if (view.id == R.id.btn_sign_in) {
            val user = UserEntity()
            user.username = binding?.etAccount?.text.toString().trim()
            user.password = binding?.etPassWord?.text.toString().trim()
            user.login = true
            loginViewModel.login(user, object : LoginViewModel.OnLoginListener {
                override fun onResult(result: Boolean) {
                    if (result) {
                        startActivity(Intent(activity, MainActivity::class.java))
                    } else {
                        Toast.makeText(activity, "账号密码错误!", Toast.LENGTH_SHORT).show()
                    }
                }

            })
        }
    }


}