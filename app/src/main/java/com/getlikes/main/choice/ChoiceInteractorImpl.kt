package com.getlikes.main.choice

import com.getlikes.network.InstagramApi
import dev.niekirk.com.instagram4android.requests.InstagramUserFeedRequest
import dev.niekirk.com.instagram4android.requests.payload.InstagramFeedResult
import io.reactivex.Observable

class ChoiceInteractorImpl(private val instagramApi: InstagramApi) : ChoiceInteractor {

    override fun getPhoto(): Observable<InstagramFeedResult> {
        return Observable.create<InstagramFeedResult> {
            val request: InstagramFeedResult = instagramApi.sendRequest(
                InstagramUserFeedRequest(instagramApi.userId, "", 0))
            it.onNext(request)
            it.onComplete()
        }
    }

}
