package com.getlikes.start

import com.getlikes.core.BaseContract

interface StartContract {
    interface View : BaseContract.View

    interface Presenter : BaseContract.Presenter<View>
}