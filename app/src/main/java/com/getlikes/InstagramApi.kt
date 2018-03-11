package com.getlikes

import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface InstagramApi {
    @FormUrlEncoded
    @POST("accounts/login/ajax/")
    fun login(@Field("username") username: String,
              @Field("password") password: String,
              @Field("next") next: String = "/"
    ): Observable<String>

}
