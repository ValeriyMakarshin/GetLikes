package com.getlikes.core

import android.os.Bundle

interface BaseContract {
    interface View

    interface Presenter<in V : View> {
        fun attach(view: V, bundle: Bundle? = null)

        fun parseArguments(extras: Bundle)

        fun loadData()

        fun detach()

        fun unsubscribeSubscription()
    }
}