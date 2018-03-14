package com.getlikes.login

import android.util.Log
import com.getlikes.core.BasePresenter
import com.getlikes.util.TokenHolder
import com.getlikes.util.storage.Storage

class LoginPresenter(val loginInteractor: LoginInteractor, val storage: Storage) :
    BasePresenter<LoginContract.View>(), LoginContract.Presenter {
    companion object {
        const val KEY_SET_COOKIE = "set-cookie"

        const val PREFIX_SESSION_ID = "sessionid="
        const val PREFIX_USER_ID = "ds_user_id="
    }

    override fun login(login: String, password: String) {
        baseObservable(loginInteractor.login(login, password),
            {
                if (it.body()?.authenticated == true) {
                    storage.putString(TokenHolder.KEY_LOGIN, login)
                    storage.putString(TokenHolder.KEY_PASSWORD, password)

                    it.headers().values(KEY_SET_COOKIE).forEach {
                        it.split("; ").forEach {
                            checkAndAdd(it, PREFIX_SESSION_ID, TokenHolder.KEY_SESSION_ID)
                            checkAndAdd(it, PREFIX_USER_ID, TokenHolder.KEY_USER_ID)
                        }
                    }

                    Log.i("132 LoginPresenter", "onNext")

                    getUserName()
                }
            })

    }

    fun getUserName() {
        unsubscribeSubscription()
        baseObservable(loginInteractor.getUserData(),
            {
                Log.i("132 LoginPresenter", "onNext")
                it.formData?.username?.let { username ->
                    storage.putString(TokenHolder.KEY_USERNAME, username)
                }
            }, {
        })

    }

    override fun like() {
        baseObservable(loginInteractor.like(),
            {
                Log.i("132 LoginPresenter", "onNext")
            }, {
            Log.i("132 LoginPresenter", "onError")
        })
    }

    private fun checkAndAdd(check: String, prefix: String, key: String) {
        if (check.startsWith(prefix)) {
            storage.putString(key, check.split("=")[1])
        }
    }
}
