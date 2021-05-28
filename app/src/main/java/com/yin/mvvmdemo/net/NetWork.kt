package com.yin.mvvmdemo.net

import android.util.Log
import com.yin.mvvmdemo.net.apis.Api
import okhttp3.Interceptor
import okhttp3.Interceptor.Companion.invoke
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.CallAdapter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class NetWork {
    companion object {
        val TAG: String = "NetWork"

        fun getOkHttpClient(): OkHttpClient? {
            var loggingInterceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger {
                Log.w(NetWork.TAG, "retrofitBack = $it")
            })
            var level = HttpLoggingInterceptor.Level.BASIC
            loggingInterceptor.setLevel(level)


            var httpClientBuilder = OkHttpClient.Builder()
            httpClientBuilder.addInterceptor(loggingInterceptor)
                .addInterceptor(invoke {
                    val request = it.request()
                        .newBuilder()
                        .addHeader("Content-Type", "application/json;charset=UTF-8")
                        .build()
                    it.proceed(request)
                })
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)

            return httpClientBuilder.build()
        }

        val okHttp_Client = getOkHttpClient()
        val gsonConverterFactory: GsonConverterFactory = GsonConverterFactory.create()
        val rxJavaCallAdapterFactory: CallAdapter.Factory = RxJava2CallAdapterFactory.create()
        val retrofit = Retrofit.Builder()
            .client(okHttp_Client)
            .baseUrl(UrlConstant.feed_url)
            .addConverterFactory(gsonConverterFactory)
            .addCallAdapterFactory(rxJavaCallAdapterFactory)
            .build()

        private var api: Api? = null

        fun getApi(): Api? {
            if(api == null){
                api = retrofit.create(Api::class.java)
            }
            return api
        }





    }

}