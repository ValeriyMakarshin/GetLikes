package com.getlikes

import android.app.Application
import android.content.Context
import com.crashlytics.android.Crashlytics
import com.getlikes.di.AppKodein
import com.getlikes.login.LoginContract
import com.getlikes.login.LoginInteractor
import com.getlikes.login.LoginInteractorImpl
import com.getlikes.login.LoginPresenter
import com.getlikes.main.MainContract
import com.getlikes.main.MainPresenter
import com.getlikes.main.choice.di.ChoiceKodein
import com.getlikes.main.earncoins.EarnCoinsContract
import com.getlikes.main.earncoins.EarnCoinsPresenter
import com.getlikes.main.hashtags.HashTagsContract
import com.getlikes.main.hashtags.HashTagsPresenter
import com.getlikes.network.NetworkUtils
import com.getlikes.splash.SplashContract
import com.getlikes.splash.SplashInteractor
import com.getlikes.splash.SplashInteractorImpl
import com.getlikes.splash.SplashPresenter
import com.getlikes.start.StartContract
import com.getlikes.start.StartPresenter
import com.getlikes.util.storage.Storage
import com.github.salomonbrys.kodein.*
import io.fabric.sdk.android.Fabric

class App : Application(), KodeinAware {
    companion object {
        lateinit var INSTANCE: App
    }

    override val kodein = Kodein {
        import(AppKodein.initModule())

        bind<SplashInteractor>() with singleton { SplashInteractorImpl(instance()) }
        bind<SplashContract.Presenter>() with singleton { SplashPresenter(instance()) }

        bind<StartContract.Presenter>() with singleton { StartPresenter() }

        bind<LoginInteractor>() with singleton { LoginInteractorImpl(instance(), instance()) }
        bind<LoginContract.Presenter>() with singleton { LoginPresenter(instance(), instance()) }

        bind<MainContract.Presenter>() with singleton { MainPresenter() }

        import(ChoiceKodein.initModule())

        bind<EarnCoinsContract.Presenter>() with singleton { EarnCoinsPresenter() }

        bind<HashTagsContract.Presenter>() with singleton { HashTagsPresenter() }
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this

        Fabric.with(this, Crashlytics())

        NetworkUtils.init(this)

        checkFirstRun()
    }

    private fun checkFirstRun() {
        val storage: Storage = kodein.instance()

        if (storage.checkContains(Storage.KEY_FIRST_RUN)) {
            storage.putBoolean(Storage.KEY_FIRST_RUN, false)
        } else {
            storage.putBoolean(Storage.KEY_FIRST_RUN, true)
        }
    }

}
