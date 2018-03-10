package com.getlikes.start

import com.getlikes.R
import com.getlikes.core.ActivityInfo
import com.getlikes.core.BaseActivity
import com.github.salomonbrys.kodein.instance
import kotlinx.android.synthetic.main.activity_start.*

class StartActivity : BaseActivity<StartContract.View, StartContract.Presenter>(),
    StartContract.View {

    override val presenter: StartContract.Presenter by instance()

    override val activityInfo: ActivityInfo = ActivityInfo(R.layout.activity_start)

    override fun viewInit() {
        super.viewInit()

        uiGetStartedBt.setOnClickListener { presenter.goToLogin() }
    }
}

