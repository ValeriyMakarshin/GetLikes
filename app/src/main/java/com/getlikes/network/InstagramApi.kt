package com.getlikes.network

import com.getlikes.model.Status
import com.getlikes.model.edit.EditModel
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface InstagramApi {

    @FormUrlEncoded
    @POST("accounts/login/ajax/")
    fun login(@Field("username") username: String,
              @Field("password") password: String,
              @Field("next") next: String = "/"
    ): Observable<Response<Status>>

    @POST("/web/likes/1732569799068097430/like/?hl=ru")
    fun like(): Observable<Status>

    @GET("/accounts/edit/?__a=1")
    fun userData(): Observable<EditModel>



}
