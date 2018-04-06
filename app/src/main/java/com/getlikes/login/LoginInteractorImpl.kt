package com.getlikes.login

import com.getlikes.model.Answer
import com.getlikes.model.LoginModel
import com.getlikes.model.Session
import com.getlikes.network.Api
import dev.niekirk.com.instagram4android.Instagram4Android
import dev.niekirk.com.instagram4android.requests.payload.InstagramLoginResult
import io.reactivex.Single


class LoginInteractorImpl(private val api: Api,
                          private val instagram4Android: Instagram4Android) : LoginInteractor {
    override fun loginInstagram(login: String, password: String): Single<InstagramLoginResult> {
        instagram4Android.username = login
        instagram4Android.password = password
        return Single.create<InstagramLoginResult> {
            instagram4Android.setup()
            it.onSuccess(instagram4Android.login())
        }
    }

    override fun loginApi(loginModel: LoginModel): Single<Answer<Session>> {
        return api.login(loginModel)
    }
}
