package com.getlikes.network

import com.getlikes.model.Answer
import com.getlikes.model.LoginModel
import com.getlikes.model.Session
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface Api {

    @POST("login")
    fun login(@Body loginModel: LoginModel): Single<Answer<Session>>

    @FormUrlEncoded
    @POST("balance")
    fun balance(@Field("session_id") sessionId: String
    ): Single<String>

    @FormUrlEncoded
    @POST("task")
    fun task(@Field("session_id") sessionId: String
    ): Single<String>

    @FormUrlEncoded
    @POST("skip")
    fun skip(@Field("session_id") sessionId: String
    ): Single<String>

    @FormUrlEncoded
    @POST("like")
    fun like(@Field("session_id") sessionId: String,
             @Field("media_id") mediaId: Long
    ): Single<String>


    @FormUrlEncoded
    @POST("order")
    fun order(@Field("session_id") sessionId: String,
              @Field("thumbnail_url") thumbnailUrl: String,
              @Field("standard_resolution_url") standardResolutionUrl: String,
              @Field("amount") amount: Int

    ): Single<String>

}
