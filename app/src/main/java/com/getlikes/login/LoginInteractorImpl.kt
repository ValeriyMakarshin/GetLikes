package com.getlikes.login

import com.getlikes.model.Answer
import com.getlikes.model.LoginModel
import com.getlikes.model.Session
import com.getlikes.network.Api
import dev.niekirk.com.instagram4android.Instagram4Android
import dev.niekirk.com.instagram4android.requests.payload.InstagramLoginResult
import io.reactivex.Observable


class LoginInteractorImpl(private val api: Api,
                          private val instagram4Android: Instagram4Android) : LoginInteractor {
    override fun loginInstagram(login: String, password: String): Observable<InstagramLoginResult> {
        instagram4Android.username = login
        instagram4Android.password = password
        return Observable.create<InstagramLoginResult> {
            instagram4Android.setup()
            it.onNext(instagram4Android.login())
            it.onComplete()
        }
    }

    override fun loginApi(loginModel: LoginModel): Observable<Answer<Session>> {
        return api.login(loginModel)
    }
}
