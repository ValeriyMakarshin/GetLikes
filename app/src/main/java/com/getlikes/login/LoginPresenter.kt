package com.getlikes.login

import com.getlikes.core.BasePresenter
import com.getlikes.util.storage.Storage

class LoginPresenter(private val loginInteractor: LoginInteractor, private val storage: Storage) :
    BasePresenter<LoginContract.View>(), LoginContract.Presenter {

    override fun loginInstagram(login: String, password: String) {
        baseSingle(loginInteractor.loginInstagram(login, password), {
            view?.goToMain()
        })
    }
}
