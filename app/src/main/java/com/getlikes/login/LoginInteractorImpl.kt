package com.getlikes.login

import com.getlikes.network.InstagramApi
import io.reactivex.Observable

class LoginInteractorImpl(private val instagramApi: InstagramApi) : LoginInteractor {
    override fun login(login: String, password: String): Observable<String> {
        return instagramApi.login(login, password)
    }

}