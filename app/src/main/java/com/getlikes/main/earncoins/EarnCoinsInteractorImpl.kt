package com.getlikes.main.earncoins

import com.getlikes.model.Answer
import com.getlikes.model.Task
import com.getlikes.network.Api
import com.getlikes.util.TokenHolder
import io.reactivex.Observable

class EarnCoinsInteractorImpl(private val tokenHolder: TokenHolder,
                              private val api: Api) : EarnCoinsInteractor {
    override fun getTask(): Observable<Answer<Task>> {
        return tokenHolder.session?.let { api.task(it) }
            ?: throw IllegalArgumentException("Session must be not null")
    }
}
