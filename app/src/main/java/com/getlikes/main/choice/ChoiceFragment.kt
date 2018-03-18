package com.getlikes.main.choice

import com.getlikes.R
import com.getlikes.core.ActivityInfo
import com.getlikes.core.BaseFragment
import com.github.salomonbrys.kodein.instance

class ChoiceFragment : BaseFragment<ChoiceContract.View, ChoiceContract.Presenter>(),
    ChoiceContract.View {

    override val presenter: ChoiceContract.Presenter by instance()

    override val activityInfo: ActivityInfo
        get() = ActivityInfo(R.layout.fragment_choice)


}
