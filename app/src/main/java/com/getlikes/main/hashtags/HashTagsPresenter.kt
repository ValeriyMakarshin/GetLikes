package com.getlikes.main.hashtags

import android.util.Log
import com.crashlytics.android.Crashlytics
import com.getlikes.core.BasePresenter

class HashTagsPresenter(val hashTagsInteractor: HashTagsInteractor) :
    BasePresenter<HashTagsContract.View>(), HashTagsContract.Presenter {

    override fun loadData() {
        baseSingle(hashTagsInteractor.getTagGroup(), {
            Log.e("132", "132")
        }, {
            Crashlytics.logException(it)
        })
    }

}
