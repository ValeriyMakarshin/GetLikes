package com.getlikes

import android.app.Application
import com.crashlytics.android.Crashlytics
import com.facebook.stetho.Stetho
import com.getlikes.login.LoginContract
import com.getlikes.login.LoginInteractor
import com.getlikes.login.LoginInteractorImpl
import com.getlikes.login.LoginPresenter
import com.getlikes.start.StartContract
import com.getlikes.start.StartPresenter
import com.github.salomonbrys.kodein.*
import io.fabric.sdk.android.Fabric

class App : Application(), KodeinAware {
    companion object {
        const val TAG_INSTAGRAM = "tag_instagram"
    }

    override val kodein by Kodein.lazy {
        //        import(autoAndroidModule(this@App))

        bind<InstagramApi>(TAG_INSTAGRAM) with singleton { Network.getInsagramApi() }

        bind<StartContract.Presenter>() with singleton { StartPresenter() }

        bind<LoginInteractor>() with singleton { LoginInteractorImpl(instance(TAG_INSTAGRAM)) }
        bind<LoginContract.Presenter>() with singleton { LoginPresenter(instance()) }
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
