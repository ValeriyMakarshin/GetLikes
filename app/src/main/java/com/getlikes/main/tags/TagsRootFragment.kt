package com.getlikes.main.tags

import com.getlikes.Navigator
import com.getlikes.R
import com.getlikes.core.ActivityInfo
import com.getlikes.core.BaseFragment
import com.github.salomonbrys.kodein.instance

class TagsRootFragment : BaseFragment<TagsRootContract.View, TagsRootContract.Presenter>(),
    TagsRootContract.View {

    override val presenter: TagsRootContract.Presenter by instance()

    override val activityInfo: ActivityInfo = ActivityInfo(R.layout.fragment_tags_root)

    override fun choiceCategory() {
        Navigator.tagCategories(fragmentManager, R.id.uiTagContainerFl)
    }
}
