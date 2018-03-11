package com.getlikes.login

import com.getlikes.network.InstagramApi
import io.reactivex.Observable

class LoginInteractorImpl(private val instagramApi: InstagramApi) : LoginInteractor {
    override fun login(login: String, password: String):
        Observable<retrofit2.Response<Map<String, String>>> {
        return instagramApi.login(login, password)
    }

}
