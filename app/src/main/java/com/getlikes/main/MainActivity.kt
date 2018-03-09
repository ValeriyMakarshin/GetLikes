package com.getlikes.main

import android.os.Bundle
import com.getlikes.R
import com.getlikes.adapter.MainPagerAdapter
import com.getlikes.core.ActivityInfo
import com.getlikes.core.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainPresentationModel>() {
    override val activityInfo: ActivityInfo
        get() = ActivityInfo(R.layout.activity_main)

    override fun providePresentationModel(): MainPresentationModel = MainPresentationModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpPagerAdapter()
    }

    fun setUpPagerAdapter() {
        val mainPagerAdapter = MainPagerAdapter(supportFragmentManager, this)
        uiMainVp.adapter = mainPagerAdapter
        uiMainVp.offscreenPageLimit = 3
        uiMainTl.setupWithViewPager(uiMainVp)
    }
}
