package com.yin.mvvmdemo.step5

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.yin.mvvmdemo.R
import com.yin.mvvmdemo.databinding.ActivitySaveStateBinding

class SaveStateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.w("scj", "onCreate packName -->" + getPackageName())
        val binding: ActivitySaveStateBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_save_state)

        val savedStateViewModel = ViewModelProvider(this).get(SavedStateViewModel::class.java)
//        val savedStateViewModel: SavedStateViewModel by viewModels()

        Log.w("scj", "onCreate packName -->" + savedStateViewModel.KEY_NAME)

        savedStateViewModel.name.observe(this, object : Observer<String>{
            override fun onChanged(t: String?) {
                binding.savedVmTv.text = resources.getString(R.string.saved_in_vm, t)
            }

        })

        binding.saveBt.setOnClickListener {
            savedStateViewModel.setName(binding.nameEt.text.toString())
        }

        binding.savePrint.setOnClickListener {
            Log.w("scj", "print--->" + savedStateViewModel.name.value)
        }
    }
}