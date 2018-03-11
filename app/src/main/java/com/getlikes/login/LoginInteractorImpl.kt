package com.getlikes.login

import com.getlikes.model.Authenticity
import com.getlikes.network.InstagramApi
import io.reactivex.Observable
import retrofit2.Response

class LoginInteractorImpl(private val instagramApi: InstagramApi) : LoginInteractor {
    override fun login(login: String, password: String): Observable<Response<Authenticity>> {
        return instagramApi.login(login, password)
    }

}
