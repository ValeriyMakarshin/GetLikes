package com.getlikes.splash

import com.getlikes.network.InstagramApi

class SplashInteractorImpl(val instagramApi: InstagramApi)
    : SplashInteractor {

    override fun checkLogin(): Boolean = instagramApi.isLoggedIn

}
