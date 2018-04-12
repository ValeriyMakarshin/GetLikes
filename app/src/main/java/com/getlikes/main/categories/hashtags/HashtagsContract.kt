package com.getlikes.main.categories.hashtags

import com.getlikes.core.BaseContract

interface HashtagsContract {
    interface View : BaseContract.View

    interface Presenter : BaseContract.Presenter<View>
}