package com.getlikes.main.hashtags

import com.getlikes.core.BaseContract

interface HashTagsContract {
    interface View : BaseContract.View

    interface Presenter : BaseContract.Presenter<View>

}
