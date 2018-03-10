package com.getlikes

import android.app.Application
import com.crashlytics.android.Crashlytics
import com.getlikes.login.LoginContract
import com.getlikes.login.LoginPresenter
import com.getlikes.start.StartContract
import com.getlikes.start.StartPresenter
import com.github.salomonbrys.kodein.*
import com.github.salomonbrys.kodein.android.autoAndroidModule
import io.fabric.sdk.android.Fabric

class App : Application(), KodeinAware {
    companion object {
        const val TAG_INSTAGRAM = "tag_instagram"
    }

    override val kodein by Kodein.lazy {
        import(autoAndroidModule(this@App))

        bind<InstagramApi>(TAG_INSTAGRAM) with instance(Network.getInsagramApi())
        bind<StartContract.Presenter>() with instance(StartPresenter())
        bind<LoginContract.Presenter>() with instance(LoginPresenter())
    }

    override fun onCreate() {
        super.onCreate()
        Fabric.with(this, Crashlytics())
    }
}
