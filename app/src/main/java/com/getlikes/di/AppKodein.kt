package com.getlikes.di

import android.content.Context
import com.getlikes.App
import com.getlikes.login.di.LoginKodein
import com.getlikes.main.di.MainKodein
import com.getlikes.network.Api
import com.getlikes.network.NetworkBase
import com.getlikes.splash.di.SplashKodein
import com.getlikes.util.Strings
import com.getlikes.util.TokenHolder
import com.getlikes.util.storage.Storage
import com.getlikes.util.storage.StorageImpl
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.singleton
import com.google.gson.Gson
import dev.niekirk.com.instagram4android.Instagram4Android

class AppKodein {
    companion object {
        fun baseKodein() = Kodein {
            import(AppKodein.initModule())
            import(SplashKodein.initModule())
            import(LoginKodein.initModule())
            import(MainKodein.initModule())
        }


        private fun initModule() = Kodein.Module {
            bind<App>() with singleton { App.INSTANCE }

            bind<Storage>() with singleton {
                StorageImpl(instance<App>().getSharedPreferences(
                    instance<App>().packageName,
                    Context.MODE_PRIVATE), Gson())
            }

            bind<TokenHolder>() with singleton { TokenHolder(instance()) }

            bind<Api>() with singleton { NetworkBase.getApi() }

            bind<Instagram4Android>() with singleton {
                Instagram4Android.builder()
                    .username(Strings.EMPTY)
                    .password(Strings.EMPTY)
                    .build()
            }

        }
    }
}
