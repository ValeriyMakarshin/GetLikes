package com.getlikes.splash

import com.getlikes.core.BaseContract

interface SplashContract {
    interface View : BaseContract.View

    interface Presenter : BaseContract.Presenter<View>
}
