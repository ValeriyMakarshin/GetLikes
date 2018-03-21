package com.getlikes.login

import com.getlikes.network.InstagramApi
import com.getlikes.util.TokenHolder
import dev.niekirk.com.instagram4android.requests.payload.InstagramLoginResult
import io.reactivex.Observable

class LoginInteractorImpl(private val tokenHolder: TokenHolder,
                          private val instagramApi: InstagramApi) : LoginInteractor {
    override fun login(login: String, password: String): Observable<InstagramLoginResult> {
        instagramApi.username = login
        instagramApi.password = password
        return Observable.create<InstagramLoginResult> {
            instagramApi.setup()
            it.onNext(instagramApi.login())
            it.onComplete()
        }.map {
            tokenHolder.saveSession(instagramApi)
            it
        }
    }

}

