package com.getlikes.main.tags.categories

import android.support.v7.widget.LinearLayoutManager
import com.getlikes.Navigator
import com.getlikes.R
import com.getlikes.adapter.CategoriesAdapter
import com.getlikes.core.ActivityInfo
import com.getlikes.core.BaseFragment
import com.getlikes.core.OnClickListener
import com.getlikes.model.Category
import com.github.salomonbrys.kodein.instance
import kotlinx.android.synthetic.main.fragment_tags_categories.*

class CategoriesFragment : BaseFragment<CategoriesContract.View, CategoriesContract.Presenter>(),
        OnClickListener<Category>, CategoriesContract.View {

    override val presenter: CategoriesContract.Presenter by instance()

    override val activityInfo: ActivityInfo = ActivityInfo(R.layout.fragment_tags_categories)

    override fun viewInit() {
        super.viewInit()
        uiCategoriesRv.layoutManager = LinearLayoutManager(context)
    }

    override fun showList(categories: ArrayList<Category>) {
        uiCategoriesRv.adapter = CategoriesAdapter(categories.toTypedArray(), this)
    }

    override fun onClick(item: Category) {
        Navigator.hashTags(item, fragmentManager, R.id.uiTagContainerFl)
    }

}

