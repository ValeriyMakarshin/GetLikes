package com.getlikes.login

import com.getlikes.core.BaseContract

interface LoginContract {
    interface View : BaseContract.View {
        fun goToMain()
    }

    interface Presenter : BaseContract.Presenter<View> {
        fun login(login: String, password: String)
    }
}
