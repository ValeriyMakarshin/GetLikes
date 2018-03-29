package com.getlikes.main.earncoins

import com.getlikes.network.Api
import com.getlikes.util.TokenHolder
import io.reactivex.Observable

class EarnCoinsInteractorImpl(private val tokenHolder: TokenHolder,
                              private val api: Api) : EarnCoinsInteractor {
    override fun getTask(): Observable<String> {
        return tokenHolder.session?.let { api.task(it) }
            ?: throw IllegalArgumentException("Session must be not null")
    }
}
