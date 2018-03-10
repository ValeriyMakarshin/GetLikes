package com.getlikes.main

import com.getlikes.R
import com.getlikes.core.ActivityInfo
import com.getlikes.core.BaseActivity

class MainActivity : BaseActivity<MainContract.View, MainContract.Presenter>(), MainContract.View {
    override val activityInfo: ActivityInfo
        get() = ActivityInfo(R.layout.activity_main)
}
