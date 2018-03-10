package com.getlikes.core

import com.arellomobile.mvp.MvpView

interface BaseContract {
    interface View : MvpView

    interface Presenter<V : View>
}