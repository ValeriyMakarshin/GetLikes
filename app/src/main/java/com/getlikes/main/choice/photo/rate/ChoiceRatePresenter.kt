package com.getlikes.main.choice.photo.rate

import android.os.Bundle
import com.getlikes.R
import com.getlikes.core.BasePresenter
import com.getlikes.model.Status
import com.getlikes.model.request.Order
import com.getlikes.util.Strings
import dev.niekirk.com.instagram4android.requests.payload.InstagramFeedItem

class ChoiceRatePresenter(private val choiceRateInteractor: ChoiceRateInteractor) :
    BasePresenter<ChoiceRateContract.View>(), ChoiceRateContract.Presenter {

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
        val order = Order(Strings.EMPTY,
            feedItem.image_versions2.candidates.first().url,
            feedItem.image_versions2.candidates.last().url,
            rates.coins)

        baseObservable(choiceRateInteractor.orderLikes(order), {
            if (it.status == Status.OK) {
                view?.showMessage(R.string.message_request_sent)
            }
        })
    }
}
