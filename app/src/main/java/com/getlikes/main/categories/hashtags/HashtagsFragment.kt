package com.getlikes.main.categories.hashtags

import android.os.Bundle
import com.getlikes.R
import com.getlikes.core.ActivityInfo
import com.getlikes.core.BaseFragment
import com.getlikes.model.Category
import com.github.salomonbrys.kodein.instance

class HashtagsFragment : BaseFragment<HashtagsContract.View, HashtagsContract.Presenter>(),
    HashtagsContract.View {

    companion object {
        const val EXTRA_CATEGORY = "extraCategory"

        fun newInstance(category: Category): HashtagsFragment {
            val fragment = HashtagsFragment()

            val args = Bundle()
            args.putSerializable(EXTRA_CATEGORY, category)
            fragment.arguments = args

            return fragment
        }

    }

    override val presenter: HashtagsContract.Presenter by instance()

    override val activityInfo: ActivityInfo = ActivityInfo(R.layout.fragment_hashtags)

}
