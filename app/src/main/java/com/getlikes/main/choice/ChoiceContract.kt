package com.getlikes.main.choice

import com.getlikes.core.BaseContract

interface ChoiceContract {
    interface View : BaseContract.View

    interface Presenter : BaseContract.Presenter<View>
}