package com.getlikes.network

import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object NetworkBase {
    const val BASE_URL = "https://getlikesapp.net/api/"
    const val SALT = "7dV~US"
    const val NAME_SIGNATURE = "signature"


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

        builder.addInterceptor { chain ->
            var request: Request = chain.request()

            val requestUrl = request.url()
            val hash = sortedSetOf(requestUrl.queryParameterNames())
                .map {
                    { name: String -> requestUrl.queryParameterValues(name) }
                }
                .joinToString().plus(SALT)

            request = request.newBuilder()
                .url(request.url()
                    .newBuilder()
                    .addQueryParameter(NAME_SIGNATURE, hash)
                    .build())
                .build()
            chain.proceed(request)
        }
        return builder.build()
    }

}
