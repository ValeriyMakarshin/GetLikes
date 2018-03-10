package com.getlikes.core

import android.os.Bundle
import com.arellomobile.mvp.MvpView

interface BaseContract {
    interface View : MvpView

    interface Presenter<V : View> {
        fun attach(view: V, bundle: Bundle? = null)

        fun parseArguments(extras: Bundle)

        fun loadData()

        fun detach()

        fun unsubscribeSubscription()
    }
}