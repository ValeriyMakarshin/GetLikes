package com.getlikes.login

import dev.niekirk.com.instagram4android.requests.payload.InstagramLoginResult
import io.reactivex.Observable

interface LoginInteractor {
    fun loginInstagram(login: String, password: String): Observable<InstagramLoginResult>

    fun loginApi(username: String, userId: Long): Observable<String>
}
