package com.getlikes.main.choice.photo.rate

import com.getlikes.model.Answer
import com.getlikes.model.OrderStatus
import com.getlikes.model.request.Order
import io.reactivex.Observable

interface ChoiceRateInteractor {
    fun orderLikes(order: Order): Observable<Answer<OrderStatus>>
}