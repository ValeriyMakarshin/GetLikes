package com.getlikes.main.choice.photo

import android.support.v7.widget.GridLayoutManager
import com.getlikes.R
import com.getlikes.adapter.SelectPhotoAdapter
import com.getlikes.core.ActivityInfo
import com.getlikes.core.BaseFragment
import com.github.salomonbrys.kodein.instance
import dev.niekirk.com.instagram4android.requests.payload.InstagramFeedItem
import kotlinx.android.synthetic.main.fragment_choice.*

class ChoicePhotoFragment : BaseFragment<ChoicePhotoContract.View, ChoicePhotoContract.Presenter>(),
    ChoicePhotoContract.View {
    companion object {
        const val SPAN_COUNT = 3
    }

    override val presenter: ChoicePhotoContract.Presenter by instance()

    override val activityInfo: ActivityInfo
        get() = ActivityInfo(R.layout.fragment_choice)

    override fun viewInit() {
        super.viewInit()
        val manager = GridLayoutManager(context, SPAN_COUNT)
        manager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int =
                if (SelectPhotoAdapter.isHeader(position))
                    manager.spanCount
                else
                    1
        }
        uiPhotoRv.layoutManager = manager

    }

    override fun showList(list: List<InstagramFeedItem>) {
        uiPhotoRv.adapter = SelectPhotoAdapter(list.toTypedArray())
    }
}
