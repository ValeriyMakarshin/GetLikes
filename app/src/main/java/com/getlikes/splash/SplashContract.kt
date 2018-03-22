package com.getlikes.splash

import com.getlikes.core.BaseContract

interface SplashContract {
    interface View : BaseContract.View {
        fun goToStart()

        fun goToLogin()
    }

    interface Presenter : BaseContract.Presenter<View>
}
