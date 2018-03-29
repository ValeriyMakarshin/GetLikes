package com.getlikes.main.choice.photo.rate

import android.support.v7.widget.LinearLayoutManager
import com.getlikes.R
import com.getlikes.adapter.RateAdapter
import com.getlikes.core.ActivityInfo
import com.getlikes.core.BaseFragment
import com.getlikes.core.OnClickListener
import com.github.salomonbrys.kodein.instance
import kotlinx.android.synthetic.main.fragment_choice.*
import kotlinx.android.synthetic.main.fragment_choice_rate.*

class ChoiceRateFragment : BaseFragment<ChoiceRateContract.View, ChoiceRateContract.Presenter>(),
    ChoiceRateContract.View, OnClickListener<Rates> {

    override val activityInfo: ActivityInfo = ActivityInfo(R.layout.fragment_choice_rate)

    override val presenter: ChoiceRateContract.Presenter by instance()

    override fun viewInit() {
        super.viewInit()
        uiRateRv.layoutManager = LinearLayoutManager(context)
    }

    override fun showList(list: List<Rates>) {
        uiPhotoRv.adapter = RateAdapter(list.toTypedArray(), this)
    }

    override fun onClick(item: Rates) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
