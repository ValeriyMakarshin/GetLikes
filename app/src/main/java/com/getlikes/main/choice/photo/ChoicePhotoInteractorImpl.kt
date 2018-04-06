package com.getlikes.main.choice.photo

import dev.niekirk.com.instagram4android.Instagram4Android
import dev.niekirk.com.instagram4android.requests.InstagramUserFeedRequest
import dev.niekirk.com.instagram4android.requests.payload.InstagramFeedResult
import io.reactivex.Single

class ChoicePhotoInteractorImpl(private val instagram4Android: Instagram4Android) :
    ChoicePhotoInteractor {

    override fun getPhoto(): Single<InstagramFeedResult> {
        return Single.create<InstagramFeedResult> {
            val request: InstagramFeedResult = instagram4Android.sendRequest(
                InstagramUserFeedRequest(instagram4Android.userId, "", 0))
            it.onSuccess(request)
        }
    }

}
