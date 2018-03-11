package com.getlikes.main.hashtags

import com.getlikes.R
import com.getlikes.core.ActivityInfo
import com.getlikes.core.BaseFragment

class HashTagsFragment : BaseFragment<HashTagsContract.View, HashTagsContract.Presenter>(),
    HashTagsContract.View {

    override val activityInfo: ActivityInfo
        get() = ActivityInfo(R.layout.fragment_hashtags)

}
