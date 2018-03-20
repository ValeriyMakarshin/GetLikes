package com.getlikes.splash

import com.getlikes.core.BasePresenter

class SplashPresenter(val splashInteractor: SplashInteractor) :
    BasePresenter<SplashContract.View>(), SplashContract.Presenter {

    override fun loadData() {
        splashInteractor.getPhoto()
    }

}
