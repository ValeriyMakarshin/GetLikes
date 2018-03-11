package com.getlikes.network

import android.icu.util.ULocale.getLanguage
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.getlikes.util.Strings
import com.getlikes.util.TokenHolder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object Network {
    const val BASE_INSTAGRAM_URL = "https://www.instagram.com/"

    fun getInsagramApi(): InstagramApi = baseInitRetrofit(BASE_INSTAGRAM_URL)


    private fun getOkHttpClient(tokenHolder: TokenHolder): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor { chain ->
                val token = tokenHolder.token
                val email = tokenHolder.email
                var request = chain.request()


                if (!Strings.isEmpty(token) &&
                    !Strings.isEmpty(email)) {
                    request = request.newBuilder()
                        .addHeader("cookie", token!!)
                        .addHeader("referer", "https://www.instagram.com/")
                        .build();
                }


                chain.proceed(request)
            }

//                .addInterceptor(chain -> {
//                String token = tokenHolder . getToken ();
//                String email = tokenHolder . getEmail ();
//                Request request = chain . request ();
//                if (token != null && !token.isEmpty() && email != null && !email.isEmpty()) {
//                    request = request.newBuilder()
//                        .addHeader("Accept-language", getLanguage())
//                        .addHeader("X-User-Token", token)
//                        .addHeader("X-User-Email", email)
//                        .build();
//                }
//                return chain.proceed(request);
//            })

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