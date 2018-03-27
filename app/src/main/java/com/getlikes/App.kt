package com.getlikes

import android.app.Application
import android.content.Context
import com.crashlytics.android.Crashlytics
import com.getlikes.login.LoginContract
import com.getlikes.login.LoginInteractor
import com.getlikes.login.LoginInteractorImpl
import com.getlikes.login.LoginPresenter
import com.getlikes.main.MainContract
import com.getlikes.main.MainPresenter
import com.getlikes.main.choice.photo.ChoicePhotoContract
import com.getlikes.main.choice.photo.ChoicePhotoInteractor
import com.getlikes.main.choice.photo.ChoicePhotoInteractorImpl
import com.getlikes.main.choice.photo.ChoicePhotoPresenter
import com.getlikes.main.choice.photo.rate.ChoiceRateContract
import com.getlikes.main.choice.photo.rate.ChoiceRatePresenter
import com.getlikes.main.choice.root.ChoiceRootContract
import com.getlikes.main.choice.root.ChoiceRootPresenter
import com.getlikes.main.earncoins.EarnCoinsContract
import com.getlikes.main.earncoins.EarnCoinsPresenter
import com.getlikes.main.hashtags.HashTagsContract
import com.getlikes.main.hashtags.HashTagsPresenter
import com.getlikes.network.Api
import com.getlikes.network.NetworkBase
import com.getlikes.network.NetworkUtils
import com.getlikes.splash.SplashContract
import com.getlikes.splash.SplashInteractor
import com.getlikes.splash.SplashInteractorImpl
import com.getlikes.splash.SplashPresenter
import com.getlikes.start.StartContract
import com.getlikes.start.StartPresenter
import com.getlikes.util.Strings
import com.getlikes.util.TokenHolder
import com.getlikes.util.storage.Storage
import com.getlikes.util.storage.StorageImpl
import com.github.salomonbrys.kodein.*
import com.google.gson.Gson
import dev.niekirk.com.instagram4android.Instagram4Android
import io.fabric.sdk.android.Fabric

class App : Application(), KodeinAware {
    companion object {
        const val TAG_INSTAGRAM = "tag_instagram"
    }

    override val kodein by Kodein.lazy {
        bind<Storage>() with singleton {
            StorageImpl(getSharedPreferences(packageName, Context.MODE_PRIVATE), Gson())
        }

        bind<TokenHolder>() with singleton { TokenHolder(instance()) }

        bind<Api>() with singleton { NetworkBase.getApi() }

        bind<Instagram4Android>() with singleton {
            Instagram4Android.builder()
                .username(Strings.EMPTY)
                .password(Strings.EMPTY)
                .build()
        }


        bind<SplashInteractor>() with singleton { SplashInteractorImpl(instance()) }
        bind<SplashContract.Presenter>() with singleton { SplashPresenter(instance()) }

        bind<StartContract.Presenter>() with singleton { StartPresenter() }

        bind<LoginInteractor>() with singleton { LoginInteractorImpl(instance(), instance()) }
        bind<LoginContract.Presenter>() with singleton { LoginPresenter(instance(), instance()) }

        bind<MainContract.Presenter>() with singleton { MainPresenter() }

        bind<ChoiceRootContract.Presenter>() with singleton { ChoiceRootPresenter() }

        bind<ChoicePhotoInteractor>() with singleton { ChoicePhotoInteractorImpl(instance()) }
        bind<ChoicePhotoContract.Presenter>() with singleton { ChoicePhotoPresenter(instance()) }

        bind<ChoiceRateContract.Presenter>() with singleton { ChoiceRatePresenter() }

        bind<EarnCoinsContract.Presenter>() with singleton { EarnCoinsPresenter() }

        bind<HashTagsContract.Presenter>() with singleton { HashTagsPresenter() }
    }

    override fun onCreate() {
        super.onCreate()
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
