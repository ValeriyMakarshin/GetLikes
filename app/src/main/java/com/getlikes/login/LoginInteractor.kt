package com.getlikes.login

import com.getlikes.model.Answer
import com.getlikes.model.LoginModel
import com.getlikes.model.Session
import dev.niekirk.com.instagram4android.requests.payload.InstagramLoginResult
import io.reactivex.Single

interface LoginInteractor {
    fun loginInstagram(login: String, password: String): Single<Answer<Session>>
}
