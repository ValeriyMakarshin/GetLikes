package com.getlikes.start

import com.getlikes.R
import com.getlikes.core.ActivityInfo
import com.getlikes.core.BaseActivity

class StartActivity : BaseActivity<StartContract.View, StartContract.Presenter>(),
    StartContract.View {

    override val activityInfo: ActivityInfo = ActivityInfo(R.layout.activity_start)
}
