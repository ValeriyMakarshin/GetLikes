package com.getlikes.main.choice.photo.rate

import android.os.Bundle
import com.getlikes.core.BasePresenter
import dev.niekirk.com.instagram4android.requests.payload.InstagramFeedItem

class ChoiceRatePresenter : BasePresenter<ChoiceRateContract.View>(),
    ChoiceRateContract.Presenter {
    private lateinit var feedItem: InstagramFeedItem

    override fun parseArguments(extras: Bundle) {
        super.parseArguments(extras)

        feedItem = extras.getSerializable(ChoiceRateFragment.EXTRA_FEED_ITEM) as InstagramFeedItem
    }

    override fun attach(view: ChoiceRateContract.View, bundle: Bundle?) {
        super.attach(view, bundle)

        view.showList(Rates.values(), feedItem)
    }

    override fun orderLikes(rates: Rates) {

    }
}
