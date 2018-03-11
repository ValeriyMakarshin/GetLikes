package com.getlikes.main.earncoins

import com.getlikes.core.BaseContract

interface EarnCoinsContract {
    interface View : BaseContract.View

    interface Presenter : BaseContract.Presenter<View>
}
