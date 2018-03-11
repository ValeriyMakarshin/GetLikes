package com.getlikes.main.earncoins

import com.getlikes.R
import com.getlikes.core.ActivityInfo
import com.getlikes.core.BaseFragment

class EarnCoinsFragment : BaseFragment<EarnCoinsContract.View, EarnCoinsContract.Presenter>(),
    EarnCoinsContract.View {

    override val activityInfo: ActivityInfo
        get() = ActivityInfo(R.layout.fragment_earncoins)

}
