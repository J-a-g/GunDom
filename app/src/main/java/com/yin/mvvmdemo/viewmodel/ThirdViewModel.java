package com.yin.mvvmdemo.viewmodel;

import android.content.Context;

import androidx.databinding.ObservableField;

public class ThirdViewModel {

    private Context context;
    public final ObservableField<String> name = new ObservableField<>();

    public ThirdViewModel() {
        name.set("suhcengjian");
    }
}
