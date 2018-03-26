package com.getlikes.main.choice.photo

import dev.niekirk.com.instagram4android.requests.payload.InstagramFeedResult
import io.reactivex.Observable

interface ChoicePhotoInteractor {
    fun getPhoto(): Observable<InstagramFeedResult>
}
