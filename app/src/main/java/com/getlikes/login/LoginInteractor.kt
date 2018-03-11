package com.getlikes.login

import com.getlikes.model.Status
import io.reactivex.Observable
import retrofit2.Response

interface LoginInteractor {
    fun login(login: String, password: String): Observable<Response<Status>>

    fun like(): Observable<Status>
}
