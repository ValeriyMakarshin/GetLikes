package com.getlikes.login

import android.os.Bundle
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

        const val PREFIX_SESSION_ID = "sessionid="
        const val PREFIX_USER_ID = "ds_user_id="
    }

    val loginUrl: String = "https://www.instagram.com/oauth/authorize/?" +
        "client_id=$CLIENT_ID&" +
        "redirect_uri=$REDIRECT_URL&" +
        "response_type=code"

    override fun attach(view: LoginContract.View, bundle: Bundle?) {
        super.attach(view, bundle)
//        view.openWebView(loginUrl)
    }

    override fun login(login: String, password: String) {
        loginInteractor.login(login, password)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    val headers = it.headers().values("set-cookie")
//                    headers.forEach { it.split("; ").forEach {  } }
                    for (setCookies: String in headers) {
                        for (valuesGroup: String in setCookies.split("; ")) {
                            checkAndAdd(valuesGroup, PREFIX_SESSION_ID, TokenHolder.KEY_SESSION_ID)
                            checkAndAdd(valuesGroup, PREFIX_USER_ID, TokenHolder.KEY_USER_ID)
                        }
                    }
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
