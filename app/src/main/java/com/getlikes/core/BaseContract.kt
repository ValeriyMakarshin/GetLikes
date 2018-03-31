package com.getlikes.core

import android.os.Bundle
import android.support.annotation.StringRes

interface BaseContract {
    interface View {
        fun showError(throwable: Throwable)

        fun showMessage(@StringRes messageId: Int)

        fun showProgress()

        fun hideProgress()
    }

    interface Presenter<in V : View> {
        fun attach(view: V, bundle: Bundle? = null)

        fun parseArguments(extras: Bundle)

        fun loadData()

        fun detach()

        fun unsubscribeSubscription()
    }
}
