package com.getlikes.main

import com.getlikes.R
import com.getlikes.adapter.MainPagerAdapter
import com.getlikes.core.ActivityInfo
import com.getlikes.core.BaseActivity
import com.github.salomonbrys.kodein.instance
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainContract.View, MainContract.Presenter>(), MainContract.View {
    override val presenter: MainContract.Presenter by instance()

    override val activityInfo: ActivityInfo
        get() = ActivityInfo(R.layout.activity_main)

    override fun viewInit() {
        super.viewInit()

        uiMainVp.adapter = MainPagerAdapter(supportFragmentManager, this)
        uiMainTl.setupWithViewPager(uiMainVp)
    }
}
