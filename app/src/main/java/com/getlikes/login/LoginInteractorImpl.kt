package com.getlikes.login

import com.getlikes.model.Status
import com.getlikes.model.edit.EditModel
import com.getlikes.network.InstagramApi
import io.reactivex.Observable
import retrofit2.Response

class LoginInteractorImpl(private val instagramApi: InstagramApi) : LoginInteractor {
    override fun login(login: String, password: String): Observable<Response<Status>> {
        return instagramApi.login(login, password)
    }

    override fun like(): Observable<Status> {
        return instagramApi.like()
    }

    override fun getUserData(): Observable<EditModel> {
        return instagramApi.userData()
    }
}
