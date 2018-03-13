package com.getlikes.login

import android.util.Log
import com.getlikes.core.BasePresenter
import com.getlikes.util.TokenHolder
import com.getlikes.util.storage.Storage
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class LoginPresenter(val loginInteractor: LoginInteractor, val storage: Storage) :
    BasePresenter<LoginContract.View>(), LoginContract.Presenter {
    companion object {
        const val CLIENT_ID = "b42369aada9d4b9cbaf56c12963d01b3"
        const val REDIRECT_URL = "http://localhost"

        const val KEY_SET_COOKIE = "set-cookie"

        const val PREFIX_SESSION_ID = "sessionid="
        const val PREFIX_USER_ID = "ds_user_id="
    }

    override fun login(login: String, password: String) {
        loginInteractor.login(login, password)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    Log.i("132 LoginPresenter", "onNext")
                    if (it.body()?.authenticated == true) {
                        storage.putString(TokenHolder.KEY_USERNAME, login)
                        storage.putString(TokenHolder.KEY_PASSWORD, password)

                        it.headers().values(KEY_SET_COOKIE).forEach {
                            it.split("; ").forEach {
                                checkAndAdd(it, PREFIX_SESSION_ID, TokenHolder.KEY_SESSION_ID)
                                checkAndAdd(it, PREFIX_USER_ID, TokenHolder.KEY_USER_ID)
                            }
                        }
                    }
                }, {
                Log.i("132 LoginPresenter", "onError")
            })

    }

    override fun like() {
        loginInteractor.like()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
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
