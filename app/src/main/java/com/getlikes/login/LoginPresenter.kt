package com.getlikes.login

import android.os.Bundle
import android.util.Log
import com.getlikes.core.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class LoginPresenter(val loginInteractor: LoginInteractor) :
    BasePresenter<LoginContract.View>(), LoginContract.Presenter {

    companion object {
        const val CLIENT_ID = "b42369aada9d4b9cbaf56c12963d01b3"
        const val REDIRECT_URL = "http://localhost"
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
                    Log.i("132 LoginPresenter", "onNext")
                }, {
                Log.i("132 LoginPresenter", "onError")
            })

    }
}
