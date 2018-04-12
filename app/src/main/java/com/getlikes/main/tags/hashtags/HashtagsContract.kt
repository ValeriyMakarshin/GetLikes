package com.getlikes.main.tags.hashtags

import com.getlikes.core.BaseContract

interface HashtagsContract {
    interface View : BaseContract.View

    interface Presenter : BaseContract.Presenter<View>
}