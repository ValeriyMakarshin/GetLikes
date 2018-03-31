package com.getlikes.main.choice.photo.rate

import com.getlikes.model.request.Order
import com.getlikes.network.Api
import com.getlikes.util.TokenHolder

class ChoiceRateInteractorImpl(private val api: Api,
                               private val tokenHolder: TokenHolder) : ChoiceRateInteractor {
    override fun orderLikes(order: Order) {
        tokenHolder.session?.sessionId?.run { order.sessionId = this }
        api.order(order)
    }

}