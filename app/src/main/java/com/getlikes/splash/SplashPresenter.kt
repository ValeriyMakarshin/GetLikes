package com.getlikes.splash

import android.os.Bundle
import com.getlikes.core.BasePresenter

class SplashPresenter(val splashInteractor: SplashInteractor) :
    BasePresenter<SplashContract.View>(), SplashContract.Presenter {


    override fun attach(view: SplashContract.View, bundle: Bundle?) {
        super.attach(view, bundle)

    }

    fun nextNavigate() {
        if (splashInteractor.checkLogin()) {
            view?.goToMain()
        } else {
            view?.goToLogin()
        }
    }
}
