package com.getlikes.login

import com.getlikes.model.LoginModel
import dev.niekirk.com.instagram4android.requests.payload.InstagramLoginResult
import io.reactivex.Observable

interface LoginInteractor {
    fun loginInstagram(login: String, password: String): Observable<InstagramLoginResult>

    fun loginApi(loginModel: LoginModel): Observable<Map<String, String>>
}
