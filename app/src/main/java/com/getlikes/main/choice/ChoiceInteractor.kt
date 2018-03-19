package com.getlikes.main.choice

import dev.niekirk.com.instagram4android.requests.payload.InstagramFeedResult
import io.reactivex.Observable

interface ChoiceInteractor {
    fun getPhoto(): Observable<InstagramFeedResult>
}
