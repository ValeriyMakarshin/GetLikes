package com.getlikes.network

import android.content.Context
import com.facebook.stetho.Stetho
import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.OkHttpClient

class NetworkUtils {
    companion object {
        fun addStethoInterceptor(builder: OkHttpClient.Builder) {
            builder.addNetworkInterceptor(StethoInterceptor())
        }

        fun init(context: Context) {
            Stetho.initialize(
                Stetho.newInitializerBuilder(context)
                    .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(context))
                    .enableDumpapp(Stetho.defaultDumperPluginsProvider(context))
                    .build())
        }
    }
}
