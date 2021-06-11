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
//        seekBarViewModel = SeekBarViewModel()
        seekBarViewModel = ViewModelProvider(requireActivity()).get(SeekBarViewModel::class.java)

        subscribeSeekBar()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    fun subscribeSeekBar() {
        binding.sb.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if(fromUser){
                    Log.d("scj", "Progress changed! hascode:" + binding.sb.hashCode())
                    seekBarViewModel.seekbarValue.value = progress
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })

        Log.w("scj", "seekBarViewModel->" + seekBarViewModel.hashCode())
        seekBarViewModel.seekbarValue.observe(requireActivity(),
            Observer<Int> { t ->
                if(t != null){
                    Log.w("scj", "" + binding.sb.hashCode() + " onChanged value:" + t)
                    binding.sb.progress = t
                }
            })
    }
}