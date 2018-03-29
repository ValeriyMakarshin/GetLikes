package com.getlikes.splash.di

import com.getlikes.splash.SplashContract
import com.getlikes.splash.SplashInteractor
import com.getlikes.splash.SplashInteractorImpl
import com.getlikes.splash.SplashPresenter
import com.getlikes.splash.start.StartContract
import com.getlikes.splash.start.StartPresenter
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.singleton

class SplashKodein {
    companion object {
        fun initModule() = Kodein.Module {
            bind<SplashInteractor>() with singleton { SplashInteractorImpl(instance()) }
            bind<SplashContract.Presenter>() with singleton { SplashPresenter(instance()) }

            bind<StartContract.Presenter>() with singleton { StartPresenter() }
        }
    }
}