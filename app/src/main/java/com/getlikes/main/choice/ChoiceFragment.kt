package com.getlikes.main.choice

import android.support.v7.widget.GridLayoutManager
import com.getlikes.R
import com.getlikes.adapter.SelectPhotoAdapter
import com.getlikes.core.ActivityInfo
import com.getlikes.core.BaseFragment
import com.github.salomonbrys.kodein.instance
import dev.niekirk.com.instagram4android.requests.payload.InstagramFeedItem
import kotlinx.android.synthetic.main.fragment_choice.*

class ChoiceFragment : BaseFragment<ChoiceContract.View, ChoiceContract.Presenter>(),
    ChoiceContract.View {
    companion object {
        const val SPAN_COUNT = 3
    }

    override val presenter: ChoiceContract.Presenter by instance()

    override val activityInfo: ActivityInfo
        get() = ActivityInfo(R.layout.fragment_choice)

    override fun viewInit() {
        super.viewInit()
        uiPhotoRv.layoutManager = GridLayoutManager(context, SPAN_COUNT)
    }

    override fun showList(list: List<InstagramFeedItem>) {
        uiPhotoRv.adapter = SelectPhotoAdapter(list.toTypedArray())
    }
}
