package com.getlikes.network

import okhttp3.FormBody
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

            val formBody = request.body() as FormBody

            val pairs = ArrayList<Pair<String, String>>()
            for (i in 0 until formBody.size()) {
                pairs.add(Pair(formBody.encodedName(i), formBody.encodedValue(i)))
            }

            pairs.sortWith(Comparator { o1, o2 ->
                o2?.first?.let { o1?.first?.compareTo(it) }
                    ?: throw NullPointerException("Null formBody name")
            })

            val hash = pairs.joinToString { pair -> pair.second }.plus(SALT)

            val newBody = FormBody.Builder()

            for (pair in pairs) {
                newBody.add(pair.first, pair.second)
            }

            newBody.add(NAME_SIGNATURE, hash)

            val newRequest = Request.Builder()
                .url(request.url())
                .post(newBody.build())
                .build()

            chain.proceed(newRequest)
        }
        return builder.build()
    }

}
