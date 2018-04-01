package com.getlikes.main.choice.photo.rate

import com.getlikes.model.Answer
import com.getlikes.model.OrderStatus
import com.getlikes.model.request.Order
import com.getlikes.network.Api
import com.getlikes.util.TokenHolder
import io.reactivex.Observable

class ChoiceRateInteractorImpl(private val api: Api,
                               private val tokenHolder: TokenHolder) : ChoiceRateInteractor {
    override fun orderLikes(order: Order): Observable<Answer<OrderStatus>> {
        tokenHolder.session?.sessionId?.run { order.sessionId = this }
        return api.order(order)
    }

}