package com.yin.mvvmdemo.net.interfaces

interface LoadListener<T> {
    fun loadSuccess(list: List<T>);

    fun loadFailure(t: Throwable);
}