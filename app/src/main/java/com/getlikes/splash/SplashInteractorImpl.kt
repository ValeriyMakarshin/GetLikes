package com.getlikes.splash

import android.util.Log
import com.getlikes.util.TokenHolder
import com.google.gson.Gson
import dev.niekirk.com.instagram4android.Instagram4Android

class SplashInteractorImpl(val tokenHolder: TokenHolder, val instagram4Android: Instagram4Android)
    : SplashInteractor {

    override fun getPhoto() {
        Log.d("132", "start")
        Log.d("132", Gson().toJson(instagram4Android))
        Log.d("132", "finish")
    }
}
