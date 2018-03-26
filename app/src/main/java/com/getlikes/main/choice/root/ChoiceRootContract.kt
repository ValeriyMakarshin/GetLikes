package com.getlikes.main.choice.root

import com.getlikes.core.BaseContract

interface ChoiceRootContract {
    interface View : BaseContract.View

    interface Presenter : BaseContract.Presenter<View>
}
