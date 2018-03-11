package com.getlikes.login

import io.reactivex.Observable
import retrofit2.Response

interface LoginInteractor {
    fun login(login: String, password: String): Observable<Response<Map<String, String>>>
}
