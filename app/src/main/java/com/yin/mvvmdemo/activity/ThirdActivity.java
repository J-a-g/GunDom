package com.yin.mvvmdemo.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.yin.mvvmdemo.R;
import com.yin.mvvmdemo.databinding.ActivityThirdBinding;
import com.yin.mvvmdemo.viewmodel.SecondViewModel;
import com.yin.mvvmdemo.viewmodel.ThirdViewModel;

public class ThirdActivity extends AppCompatActivity {

    private ActivityThirdBinding activityThirdBinding;
    private ThirdViewModel thirdViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityThirdBinding = DataBindingUtil.setContentView(this, R.layout.activity_third);
        thirdViewModel = new ThirdViewModel();
        activityThirdBinding.setThirdViewModel(thirdViewModel);

    }
}
