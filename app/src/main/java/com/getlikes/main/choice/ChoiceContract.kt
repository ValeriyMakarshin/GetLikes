package com.getlikes.main.choice

import com.getlikes.core.BaseContract
import dev.niekirk.com.instagram4android.requests.payload.InstagramFeedItem

interface ChoiceContract {
    interface View : BaseContract.View {
        fun showList(list: List<InstagramFeedItem>)
    }

    interface Presenter : BaseContract.Presenter<View>
}
