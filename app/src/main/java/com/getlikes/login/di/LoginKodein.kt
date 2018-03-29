package com.getlikes.login.di

import com.getlikes.login.LoginContract
import com.getlikes.login.LoginInteractor
import com.getlikes.login.LoginInteractorImpl
import com.getlikes.login.LoginPresenter
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.singleton

class LoginKodein {
    companion object {
        fun initModule() = Kodein.Module {
            bind<LoginInteractor>() with singleton {
                LoginInteractorImpl(instance(), instance(), instance())
            }
            bind<LoginContract.Presenter>() with singleton {
                LoginPresenter(instance(), instance())
            }
        }
    }
}
