package com.getlikes.main.hashtags

import com.getlikes.R
import com.getlikes.core.ActivityInfo
import com.getlikes.core.BaseFragment
import com.github.salomonbrys.kodein.instance

class HashTagsFragment : BaseFragment<HashTagsContract.View, HashTagsContract.Presenter>(),
    HashTagsContract.View {

    override val presenter: HashTagsContract.Presenter by instance()

    override val activityInfo: ActivityInfo = ActivityInfo(R.layout.fragment_hashtags)

}
