package com.getlikes.main.choice

import com.getlikes.R
import com.getlikes.core.ActivityInfo
import com.getlikes.core.BaseFragment

class ChoiceFragment : BaseFragment<ChoiceContract.View, ChoiceContract.Presenter>(),
    ChoiceContract.View {

    override val activityInfo: ActivityInfo
        get() = ActivityInfo(R.layout.fragment_choice)
}
