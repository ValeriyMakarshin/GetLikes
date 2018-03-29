package com.getlikes.main.earncoins

import com.getlikes.R
import com.getlikes.core.ActivityInfo
import com.getlikes.core.BaseFragment
import com.github.salomonbrys.kodein.instance

class EarnCoinsFragment : BaseFragment<EarnCoinsContract.View, EarnCoinsContract.Presenter>(),
    EarnCoinsContract.View {
    override val presenter: EarnCoinsContract.Presenter by instance()

    override val activityInfo: ActivityInfo = ActivityInfo(R.layout.fragment_earncoins)


}
