package com.getlikes

import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST


interface InstagramApi {
    @POST("accounts/login/ajax/")
    fun login(@Body username: String,
               @Body password: String,
               @Body next: String = "/"
    ): Observable<String>

}