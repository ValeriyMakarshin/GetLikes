package com.getlikes.login

import com.getlikes.core.BasePresenter
import com.getlikes.model.Status
import com.getlikes.util.TokenHolder
import com.getlikes.util.storage.Storage

class LoginPresenter(private val loginInteractor: LoginInteractor, private val storage: Storage) :
    BasePresenter<LoginContract.View>(), LoginContract.Presenter {

    override fun login(login: String, password: String) {
        baseObservable(loginInteractor.login(login, password),
            {
                if (Status.parseStatus(it.status) == Status.OK) {
                    storage.putString(TokenHolder.KEY_LOGIN, login)
                    storage.putString(TokenHolder.KEY_PASSWORD, password)
                    storage.putObject(TokenHolder.KEY_LOGGED_USER, it.logged_in_user)

                    view?.goToMain()
                } else {
                    view?.showError(Throwable("Test"))
                }
            })
    }

}
