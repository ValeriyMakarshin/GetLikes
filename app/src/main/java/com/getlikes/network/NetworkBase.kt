package com.getlikes.network

import com.getlikes.util.CipherUtil
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
            val request: Request = chain.request()

            val formBody = request.body() as FormBody

            val pairs = ArrayList<Pair<String, String>>()
                .apply {
                    for (i in 0 until formBody.size()) {
                        this.add(Pair(formBody.encodedName(i), formBody.encodedValue(i)))
                    }
                }

            val signature = CipherUtil.md5Hex(
                pairs
                    .apply {
                        sortWith(Comparator { o1, o2 ->
                            o2?.first?.let { o1?.first?.compareTo(it) }
                                ?: throw NullPointerException("Null formBody name")
                        })
                    }
                    .joinToString(separator = "", transform = { pair -> pair.second })
                    .plus(SALT)
            )


            val newBody = FormBody.Builder()
                .apply {
                    pairs.forEach { add(it.first, it.second) }
                    add(NAME_SIGNATURE, signature)
                }
                .build()

            val newRequest = Request.Builder()
                .url(request.url())
                .post(newBody)
                .build()

            chain.proceed(newRequest)
        }
        return builder.build()
    }

}
