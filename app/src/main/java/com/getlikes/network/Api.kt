package com.getlikes.network

import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface Api {

    @FormUrlEncoded
    @POST("login")
    fun login(@Field("username") username: String,
              @Field("user_id") user_id: Long
    ): Observable<String>


}
