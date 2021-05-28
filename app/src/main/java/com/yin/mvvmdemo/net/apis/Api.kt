package com.yin.mvvmdemo.net.apis

import com.yin.mvvmdemo.net.UrlConstant.Companion.CHECK_WHILE_LIST_API
import com.yin.mvvmdemo.net.bean.DataResponse
import com.yin.mvvmdemo.model.Feed
import io.reactivex.Observable
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface Api {

    @POST(CHECK_WHILE_LIST_API)
    fun whiteList(@Body requestBody: RequestBody): Observable<DataResponse>

    @GET(".")
    fun getFeed(): Observable<Feed>
}