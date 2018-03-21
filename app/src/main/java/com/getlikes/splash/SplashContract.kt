package com.getlikes.splash

import com.getlikes.core.BaseContract

interface SplashContract {
    interface View : BaseContract.View {
        fun goToLogin()

        fun goToMain()
    }

    interface Presenter : BaseContract.Presenter<View>
}
