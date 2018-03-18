package com.getlikes.main.choice

import dev.niekirk.com.instagram4android.Instagram4Android
import dev.niekirk.com.instagram4android.requests.InstagramUserFeedRequest
import dev.niekirk.com.instagram4android.requests.payload.InstagramFeedResult
import io.reactivex.Observable

class ChoiceInteractorImpl(private val instagram4Android: Instagram4Android) : ChoiceInteractor {

    override fun getPhoto(): Observable<InstagramFeedResult> {
        return Observable.create<InstagramFeedResult> {
            val request: InstagramFeedResult = instagram4Android.sendRequest(
                InstagramUserFeedRequest(instagram4Android.userId, "", 0))
            it.onNext(request)
            it.onComplete()
        }
    }

}