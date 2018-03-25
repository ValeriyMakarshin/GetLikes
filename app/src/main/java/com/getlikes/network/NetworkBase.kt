package com.getlikes.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object NetworkBase {
    const val BASE_URL = "https://getlikesapp.net/api/"

    fun getApi(): Api =
        Retrofit.Builder()
            .client(getOkHttpClient())
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Api::class.java)

    private fun getOkHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
        NetworkUtils.addStethoInterceptor(builder)

        builder.addInterceptor(SignatureInterceptor())

        return builder.build()
    }

}
