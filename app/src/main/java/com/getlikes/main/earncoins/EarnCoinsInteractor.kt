package com.getlikes.main.earncoins

import io.reactivex.Observable

interface EarnCoinsInteractor {
    fun getTask(): Observable<String>
}
