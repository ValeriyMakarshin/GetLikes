package com.getlikes.login

import com.getlikes.core.BaseContract

interface LoginContract {
    interface View : BaseContract.View {
        fun openWebView(loginUrl: String)
    }

    interface Presenter : BaseContract.Presenter<View>
}