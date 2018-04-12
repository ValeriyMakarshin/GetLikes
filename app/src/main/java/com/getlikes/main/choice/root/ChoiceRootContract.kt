package com.getlikes.main.choice.root

import com.getlikes.core.BaseContract

interface ChoiceRootContract {
    interface Navigator {
        fun choicePhoto()
    }

    interface View : BaseContract.View, Navigator

    interface Presenter : BaseContract.Presenter<View>
}
