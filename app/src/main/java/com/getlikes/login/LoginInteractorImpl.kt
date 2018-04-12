package com.getlikes.login

import com.getlikes.model.Answer
import com.getlikes.model.InstagramStatus
import com.getlikes.model.LoginModel
import com.getlikes.model.Session
import com.getlikes.network.Api
import com.getlikes.util.TokenHolder
import com.getlikes.util.storage.Storage
import dev.niekirk.com.instagram4android.Instagram4Android
import dev.niekirk.com.instagram4android.requests.payload.InstagramLoginResult
import io.reactivex.Single


class LoginInteractorImpl(private val api: Api,
                          private val instagram4Android: Instagram4Android,
                          private val storage: Storage) : LoginInteractor {

    override fun loginInstagram(login: String, password: String): Single<Answer<Session>> {

        instagram4Android.username = login
        instagram4Android.password = password
        return Single.create<InstagramLoginResult> {
            instagram4Android.setup()
            it.onSuccess(instagram4Android.login())
        }
            .flatMap {
                return@flatMap if (
                    InstagramStatus.parseStatus(it.status) == InstagramStatus.OK) {

                    storage.putString(TokenHolder.KEY_LOGIN, login)
                    storage.putString(TokenHolder.KEY_PASSWORD, password)
                    storage.putObject(TokenHolder.KEY_LOGGED_USER, it.logged_in_user)

                    loginApi(it)
                } else {
                    Single.error<Answer<Session>>(Throwable("Bad loginInstagram/password"))
                }
            }
    }

    private fun loginApi(instagramLoginResult: InstagramLoginResult): Single<Answer<Session>> {
        return api.login(LoginModel(instagramLoginResult.logged_in_user.username,
            instagramLoginResult.logged_in_user.pk.toString()))
    }
}
