package com.getlikes.main.tags

import com.getlikes.core.BaseContract

interface TagsRootContract {
    interface Navigator {
        fun choiceCategory()
    }

    interface View : BaseContract.View, Navigator

    interface Presenter : BaseContract.Presenter<View>
}