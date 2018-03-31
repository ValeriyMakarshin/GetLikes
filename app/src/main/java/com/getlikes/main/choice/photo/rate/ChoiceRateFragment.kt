package com.getlikes.main.choice.photo.rate

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.getlikes.R
import com.getlikes.adapter.RateAdapter
import com.getlikes.core.ActivityInfo
import com.getlikes.core.BaseFragment
import com.getlikes.core.OnClickListener
import com.github.salomonbrys.kodein.instance
import dev.niekirk.com.instagram4android.requests.payload.InstagramFeedItem
import kotlinx.android.synthetic.main.fragment_choice_rate.*

class ChoiceRateFragment : BaseFragment<ChoiceRateContract.View, ChoiceRateContract.Presenter>(),
    ChoiceRateContract.View, OnClickListener<Rates> {
    companion object {
        const val EXTRA_FEED_ITEM = "extraFeedItem"

        fun newInstance(feedItem: InstagramFeedItem): ChoiceRateFragment {
            val fragment = ChoiceRateFragment()

            val args = Bundle()
            args.putSerializable(EXTRA_FEED_ITEM, feedItem)
            fragment.arguments = args

            return fragment
        }

    }

    override val activityInfo: ActivityInfo = ActivityInfo(R.layout.fragment_choice_rate)

    override val presenter: ChoiceRateContract.Presenter by instance()

    override fun viewInit() {
        super.viewInit()
        uiRateRv.layoutManager = LinearLayoutManager(context)
    }

    override fun showList(array: Array<Rates>, feedItem: InstagramFeedItem) {
        uiRateRv.adapter = RateAdapter(array, feedItem, this)
    }

    override fun onClick(item: Rates) {
        presenter.orderLikes(item)
    }

}
