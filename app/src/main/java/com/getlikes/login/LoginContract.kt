package com.getlikes.login

import com.getlikes.core.BaseContract

interface LoginContract {
    interface View : BaseContract.View

    interface Presenter : BaseContract.Presenter<View>
}