package com.getlikes.login

import com.getlikes.model.Answer
import com.getlikes.model.request.LoginModel
import com.getlikes.model.Session
import dev.niekirk.com.instagram4android.requests.payload.InstagramLoginResult
import io.reactivex.Observable

interface LoginInteractor {
    fun loginInstagram(login: String, password: String): Observable<InstagramLoginResult>

    fun loginApi(loginModel: LoginModel): Observable<Answer<Session>>
}
