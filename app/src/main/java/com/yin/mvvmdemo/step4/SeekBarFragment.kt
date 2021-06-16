package com.yin.mvvmdemo.step4

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.yin.mvvmdemo.R
import com.yin.mvvmdemo.databinding.FragmentSeekBarBinding

//这个可以做个双向绑定
class SeekBarFragment : Fragment() {

    lateinit var binding: FragmentSeekBarBinding
    lateinit var seekBarViewModel: SeekBarViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_seek_bar, container, false)

        seekBarViewModel = ViewModelProvider(requireActivity()).get(SeekBarViewModel::class.java)

        subscribeSeekBar()
        return binding.root
    }

    fun subscribeSeekBar() {
        binding.sb.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if(fromUser){
                    //修改ViewModel中LiveData的值，会通知到onChanged中
                    seekBarViewModel.seekbarValue.value = progress
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })

        seekBarViewModel.seekbarValue.observe(requireActivity(),object : Observer<Int>{
            override fun onChanged(t: Int?) {
                if (t != null) {
                    //更新UI
                    binding.sb.progress = t
                }
            }

        })
    }
}