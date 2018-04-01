package com.getlikes.network

import com.getlikes.model.Answer
import com.getlikes.model.OrderStatus
import com.getlikes.model.Session
import com.getlikes.model.Task
import com.getlikes.model.request.LoginModel
import com.getlikes.model.request.Order
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface Api {

    @POST("login")
    fun login(@Body loginModel: LoginModel): Observable<Answer<Session>>

    @FormUrlEncoded
    @POST("balance")
    fun balance(@Field("session_id") sessionId: String
    ): Observable<String>

    @POST("task")
    fun task(@Body session: Session
    ): Observable<Answer<Task>>

    @FormUrlEncoded
    @POST("skip")
    fun skip(@Field("session_id") sessionId: String
    ): Observable<String>

    @FormUrlEncoded
    @POST("like")
    fun like(@Field("session_id") sessionId: String,
             @Field("media_id") mediaId: Long
    ): Observable<String>

    @POST("order")
    fun order(@Body order: Order): Observable<Answer<OrderStatus>>

}
