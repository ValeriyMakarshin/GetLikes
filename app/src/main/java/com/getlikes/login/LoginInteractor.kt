package com.getlikes.login

import com.getlikes.model.Status
import com.getlikes.model.edit.EditModel
import dev.niekirk.com.instagram4android.requests.payload.InstagramLoginResult
import io.reactivex.Observable
import retrofit2.Response

interface LoginInteractor {
    fun login(login: String, password: String): Observable<InstagramLoginResult>

    fun like(): Observable<*>

    fun getUserData(): Observable<*>
}
