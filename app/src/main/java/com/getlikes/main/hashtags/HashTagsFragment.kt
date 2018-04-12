package com.getlikes.main.hashtags

import android.support.v7.widget.LinearLayoutManager
import com.getlikes.R
import com.getlikes.adapter.CategoriesAdapter
import com.getlikes.core.ActivityInfo
import com.getlikes.core.BaseFragment
import com.getlikes.model.Category
import com.github.salomonbrys.kodein.instance
import kotlinx.android.synthetic.main.fragment_hashtags.*

class HashTagsFragment : BaseFragment<HashTagsContract.View, HashTagsContract.Presenter>(),
    HashTagsContract.View {

    override val presenter: HashTagsContract.Presenter by instance()

    override val activityInfo: ActivityInfo = ActivityInfo(R.layout.fragment_hashtags)

    override fun viewInit() {
        super.viewInit()
        uiTagsRv.layoutManager = LinearLayoutManager(context)
    }

    override fun showList(categories: ArrayList<Category>) {
        uiTagsRv.adapter = CategoriesAdapter()
    }

}
