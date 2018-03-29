package com.getlikes

import android.app.Application
import com.crashlytics.android.Crashlytics
import com.getlikes.di.AppKodein
import com.getlikes.network.NetworkUtils
import com.getlikes.util.storage.Storage
import com.github.salomonbrys.kodein.KodeinAware
import com.github.salomonbrys.kodein.instance
import io.fabric.sdk.android.Fabric

class App : Application(), KodeinAware {
    companion object {
        lateinit var INSTANCE: App
    }

    override val kodein = AppKodein.baseKodein()

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
