package com.getlikes.main.choice.photo.rate

import com.getlikes.model.request.Order

interface ChoiceRateInteractor {
    fun orderLikes(order: Order)
}