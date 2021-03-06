package com.getlikes.login

import android.support.annotation.VisibleForTesting
import com.getlikes.core.BasePresenter
import com.getlikes.model.InstagramStatus
import com.getlikes.model.LoginModel
import com.getlikes.util.TokenHolder
import com.getlikes.util.storage.Storage

class LoginPresenter(private val loginInteractor: LoginInteractor, private val storage: Storage) :
    BasePresenter<LoginContract.View>(), LoginContract.Presenter {

    override fun loginInstagram(login: String, password: String) {
        baseObservable(loginInteractor.loginInstagram(login, password),
            {
                if (InstagramStatus.parseStatus(it.status) == InstagramStatus.OK) {
                    storage.putString(TokenHolder.KEY_LOGIN, login)
                    storage.putString(TokenHolder.KEY_PASSWORD, password)
                    storage.putObject(TokenHolder.KEY_LOGGED_USER, it.logged_in_user)

                    loginApi(it.logged_in_user.username, it.logged_in_user.pk)
                } else {
                    view?.showError(Throwable("Bad loginInstagram/password"))
                }
            })
    }

    @VisibleForTesting fun loginApi(username: String, userId: Long) {
        unsubscribeSubscription()

        baseObservable(loginInteractor.loginApi(LoginModel(username, userId.toString())), {
            view?.goToMain()
        })
    }


}
