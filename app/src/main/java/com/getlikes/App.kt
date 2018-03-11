package com.getlikes

import android.app.Application
import android.content.Context
import com.crashlytics.android.Crashlytics
import com.facebook.stetho.Stetho
import com.getlikes.login.LoginContract
import com.getlikes.login.LoginInteractor
import com.getlikes.login.LoginInteractorImpl
import com.getlikes.login.LoginPresenter
import com.getlikes.network.InstagramApi
import com.getlikes.network.Network
import com.getlikes.start.StartContract
import com.getlikes.start.StartPresenter
import com.getlikes.util.TokenHolder
import com.getlikes.util.storage.Storage
import com.getlikes.util.storage.StorageImpl
import com.github.salomonbrys.kodein.*
import com.google.gson.Gson
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

        bind<StartContract.Presenter>() with singleton { StartPresenter() }

        bind<LoginInteractor>() with singleton { LoginInteractorImpl(instance(TAG_INSTAGRAM)) }
        bind<LoginContract.Presenter>() with singleton { LoginPresenter(instance(), instance()) }
    }

    override fun onCreate() {
        super.onCreate()
        Fabric.with(this, Crashlytics())

        Stetho.initialize(
            Stetho.newInitializerBuilder(this)
                .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                .build())

    }
}
