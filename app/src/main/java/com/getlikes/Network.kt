package com.getlikes

import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

interface Network {
    companion object {
        const val BASE_INSTAGRAM_URL = "https://www.instagram.com/"

        fun getInsagramApi(): InstagramApi = baseInitRetrofit(BASE_INSTAGRAM_URL)


        private fun getOkHttpClient(): OkHttpClient {
            return OkHttpClient.Builder()
                .addNetworkInterceptor(StethoInterceptor())
                .build()
        }


        private inline fun <reified A> baseInitRetrofit(baseUrl: String): A {
            return Retrofit.Builder()
                .client(getOkHttpClient())
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(A::class.java)
        }

    }
}