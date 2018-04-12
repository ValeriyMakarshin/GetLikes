package com.getlikes.main.hashtags

import com.crashlytics.android.Crashlytics
import com.getlikes.core.BasePresenter

class HashTagsPresenter(val hashTagsInteractor: HashTagsInteractor) :
    BasePresenter<HashTagsContract.View>(), HashTagsContract.Presenter {

    override fun loadData() {
        baseSingle(hashTagsInteractor.getTagGroup(), {
            view?.showList(it.categories)
        }, {
            Crashlytics.logException(it)
        })
    }

}
