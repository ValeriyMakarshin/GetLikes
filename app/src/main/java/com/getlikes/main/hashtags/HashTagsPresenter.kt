package com.getlikes.main.hashtags

import com.getlikes.core.BasePresenter

class HashTagsPresenter(val hashTagsInteractor: HashTagsInteractor) :
    BasePresenter<HashTagsContract.View>(), HashTagsContract.Presenter {

}
