package com.getlikes.login

import io.reactivex.Observable

interface LoginInteractor {
    fun login(login: String, password: String): Observable<String>
}
