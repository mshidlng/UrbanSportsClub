package com.urbansportsclub.assignment.api

import com.urbansportsclub.assignment.utils.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {


    private var interceptor = HttpLoggingInterceptor()
    private var oktHttpClient: OkHttpClient.Builder? = OkHttpClient.Builder()
        .addInterceptor(interceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS))


    fun getRetrofit(): ApiService {
        return Retrofit.Builder()
            .client(oktHttpClient?.build())
            .baseUrl(Constants.base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}