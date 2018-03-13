package com.getlikes.network

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.getlikes.util.TokenHolder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object Network {
    const val BASE_INSTAGRAM_URL = "https://www.instagram.com/"

    fun getInsagramApi(tokenHolder: TokenHolder): InstagramApi =
        baseInitRetrofit(BASE_INSTAGRAM_URL, tokenHolder)

    private fun getOkHttpClient(tokenHolder: TokenHolder): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor { chain ->
                val token = tokenHolder.token
                val cookie = tokenHolder.cookie
                var request = chain.request()

                request = request.newBuilder()
                    .addHeader("cookie", cookie)
                    .addHeader("x-csrftoken", token)
                    .addHeader("referer", "https://www.instagram.com/")
                    .build()

                chain.proceed(request)
            }
            .addNetworkInterceptor(StethoInterceptor())
            .build()
    }


    private inline fun <reified A> baseInitRetrofit(baseUrl: String, tokenHolder: TokenHolder): A {
        return Retrofit.Builder()
            .client(getOkHttpClient(tokenHolder))
            .baseUrl(baseUrl)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(A::class.java)
    }

}
