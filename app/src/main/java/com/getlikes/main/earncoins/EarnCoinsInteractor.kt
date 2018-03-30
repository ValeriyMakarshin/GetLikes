package com.getlikes.main.earncoins

import com.getlikes.model.Answer
import com.getlikes.model.Task
import io.reactivex.Observable

interface EarnCoinsInteractor {
    fun getTask(): Observable<Answer<Task>>
}
