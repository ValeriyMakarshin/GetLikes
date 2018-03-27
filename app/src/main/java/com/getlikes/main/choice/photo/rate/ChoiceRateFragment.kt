package com.getlikes.main.choice.photo.rate

import com.getlikes.R
import com.getlikes.core.ActivityInfo
import com.getlikes.core.BaseFragment
import com.github.salomonbrys.kodein.instance

class ChoiceRateFragment : BaseFragment<ChoiceRateContract.View, ChoiceRateContract.Presenter>(),
    ChoiceRateContract.View {

    override val activityInfo: ActivityInfo = ActivityInfo(R.layout.fragment_choice_rate)

    override val presenter: ChoiceRateContract.Presenter by instance()
}
