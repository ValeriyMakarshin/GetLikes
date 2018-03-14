package com.getlikes.login

import com.getlikes.model.Status
import com.getlikes.model.edit.EditModel
import dev.niekirk.com.instagram4android.Instagram4Android
import dev.niekirk.com.instagram4android.requests.payload.InstagramLoginResult
import io.reactivex.Observable


class LoginInteractorImpl(private val instagram4Android: Instagram4Android) : LoginInteractor {
    override fun login(login: String, password: String): Observable<InstagramLoginResult> {
        instagram4Android.username = login
        instagram4Android.password = password
        return Observable.create<InstagramLoginResult> {
            instagram4Android.setup()
            it.onNext(instagram4Android.login())
            it.onComplete()
        }
    }

    override fun like(): Observable<Status> {
        return Observable.empty()
    }

    override fun getUserData(): Observable<EditModel> {
        return Observable.empty()
    }
}
