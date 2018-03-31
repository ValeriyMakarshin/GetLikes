package com.getlikes.main.choice.photo.rate

import com.getlikes.core.BaseContract
import dev.niekirk.com.instagram4android.requests.payload.InstagramFeedItem

interface ChoiceRateContract {
    interface View : BaseContract.View {
        fun showList(array: Array<Rates>, feedItem: InstagramFeedItem)
    }

    interface Presenter : BaseContract.Presenter<View> {
        fun orderLikes(rates: Rates)
    }
}
