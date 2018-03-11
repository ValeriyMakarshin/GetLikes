package com.getlikes.main

import com.getlikes.core.BaseContract

interface MainContract {
    interface View : BaseContract.View

    interface Presenter : BaseContract.Presenter<View>
}
