package com.getlikes.start

import com.getlikes.core.BaseContract

interface StartContract {
    interface View : BaseContract.View {
        fun goToLogin()
    }

    interface Presenter : BaseContract.Presenter<View> {
        fun getStart()
    }
}
