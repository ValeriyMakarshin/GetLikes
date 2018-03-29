package com.getlikes.di

import android.content.Context
import com.getlikes.network.Api
import com.getlikes.network.NetworkBase
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
        fun initModule(context: Context) = Kodein.Module {
            bind<Storage>() with singleton {
                StorageImpl(context.getSharedPreferences(context.packageName,
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