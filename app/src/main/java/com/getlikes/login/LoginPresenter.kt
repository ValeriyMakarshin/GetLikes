package com.getlikes.login

import android.util.Log
import com.getlikes.core.BasePresenter
import com.getlikes.model.Status
import com.getlikes.util.TokenHolder
import com.getlikes.util.storage.Storage

class LoginPresenter(val loginInteractor: LoginInteractor, val storage: Storage) :
    BasePresenter<LoginContract.View>(), LoginContract.Presenter {

    override fun login(login: String, password: String) {
        baseObservable(loginInteractor.login(login, password),
            {
                Log.i("132 LoginPresenter", "onNext")
                if (Status.parseStatus(it.status) == Status.OK) {
                    storage.putString(TokenHolder.KEY_LOGIN, login)
                    storage.putString(TokenHolder.KEY_PASSWORD, password)
                    storage.putObject(TokenHolder.KEY_LOGGED_USER, it.logged_in_user)
                } else {
                    view?.showError(Throwable("Test"))
                }
            })
    }

}
