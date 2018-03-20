package com.getlikes.login

import android.os.Bundle
import android.util.Log
import com.getlikes.network.InstagramApi
import com.google.gson.Gson
import dev.niekirk.com.instagram4android.requests.payload.InstagramLoginResult
import io.reactivex.Observable

class LoginInteractorImpl(private val instagramApi: InstagramApi) : LoginInteractor {
    override fun login(login: String, password: String): Observable<InstagramLoginResult> {
        instagramApi.username = login
        instagramApi.password = password
        return Observable.create<InstagramLoginResult> {
            instagramApi.setup()
            it.onNext(instagramApi.login())
            it.onComplete()
        }.map {
            Log.i("132", "start")
            Log.i("132", Gson().toJson(instagramApi))
            Log.i("132", "finish")
            it
        }
    }

}
