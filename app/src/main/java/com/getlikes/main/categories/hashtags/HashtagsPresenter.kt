package com.getlikes.main.categories.hashtags

import android.os.Bundle
import com.getlikes.core.BasePresenter
import com.getlikes.model.Category

class HashtagsPresenter : BasePresenter<HashtagsContract.View>(), HashtagsContract.Presenter {
    lateinit var category: Category

    override fun parseArguments(extras: Bundle) {
        super.parseArguments(extras)
        category = extras.getSerializable(HashtagsFragment.EXTRA_CATEGORY) as Category
    }
}
