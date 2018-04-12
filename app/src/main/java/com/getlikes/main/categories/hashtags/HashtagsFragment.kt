package com.getlikes.main.categories.hashtags

import com.getlikes.R
import com.getlikes.core.ActivityInfo
import com.getlikes.core.BaseFragment
import com.github.salomonbrys.kodein.instance

class HashtagsFragment : BaseFragment<HashtagsContract.View, HashtagsContract.Presenter>(),
    HashtagsContract.View {

    override val presenter: HashtagsContract.Presenter by instance()

    override val activityInfo: ActivityInfo = ActivityInfo(R.layout.fragment_hashtags)

}