package com.getlikes

import android.app.Application
import android.content.Context
import com.crashlytics.android.Crashlytics
import com.facebook.stetho.Stetho
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.getlikes.login.LoginContract
import com.getlikes.login.LoginInteractor
import com.getlikes.login.LoginInteractorImpl
import com.getlikes.login.LoginPresenter
import com.getlikes.main.MainContract
import com.getlikes.main.MainPresenter
import com.getlikes.main.choice.ChoiceContract
import com.getlikes.main.choice.ChoiceInteractor
import com.getlikes.main.choice.ChoiceInteractorImpl
import com.getlikes.main.choice.ChoicePresenter
import com.getlikes.main.earncoins.EarnCoinsContract
import com.getlikes.main.earncoins.EarnCoinsPresenter
import com.getlikes.main.hashtags.HashTagsContract
import com.getlikes.main.hashtags.HashTagsPresenter
import com.getlikes.network.InstagramApi
import com.getlikes.network.Network
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

        bind<InstagramApi>(TAG_INSTAGRAM) with singleton { Network.getInsagramApi(instance()) }

        bind<Instagram4Android>() with singleton {
            Instagram4Android.builder()
                .username(Strings.EMPTY)
                .password(Strings.EMPTY)
                .build()
        }


        bind<SplashInteractor>() with singleton { SplashInteractorImpl(instance(), instance()) }
        bind<SplashContract.Presenter>() with singleton { SplashPresenter(instance()) }

        bind<StartContract.Presenter>() with singleton { StartPresenter() }

        bind<LoginInteractor>() with singleton { LoginInteractorImpl(instance()) }
        bind<LoginContract.Presenter>() with singleton { LoginPresenter(instance(), instance()) }

        bind<MainContract.Presenter>() with singleton { MainPresenter() }

        bind<ChoiceInteractor>() with singleton { ChoiceInteractorImpl(instance()) }
        bind<ChoiceContract.Presenter>() with singleton { ChoicePresenter(instance()) }

        bind<EarnCoinsContract.Presenter>() with singleton { EarnCoinsPresenter() }

        bind<HashTagsContract.Presenter>() with singleton { HashTagsPresenter() }
    }

    override fun onCreate() {
        super.onCreate()
        Fabric.with(this, Crashlytics())

        val instagram4Android: Instagram4Android = kodein.instance()

        instagram4Android.client?.networkInterceptors()?.add(StethoInterceptor())

        Stetho.initialize(
            Stetho.newInitializerBuilder(this)
                .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                .build())
    }
}
