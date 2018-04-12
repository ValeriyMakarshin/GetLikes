package com.getlikes.main.hashtags

import com.getlikes.core.BaseContract
import com.getlikes.model.Category

interface HashTagsContract {
    interface View : BaseContract.View {
        fun showList(categories: ArrayList<Category>)
    }

    interface Presenter : BaseContract.Presenter<View>

}
