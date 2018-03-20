package com.getlikes.splash

import com.getlikes.Navigator
import com.getlikes.R
import com.getlikes.core.ActivityInfo
import com.getlikes.core.BaseActivity
import com.github.salomonbrys.kodein.instance

class SplashActivity : BaseActivity<SplashContract.View, SplashContract.Presenter>(),
    SplashContract.View {

    override val activityInfo: ActivityInfo = ActivityInfo(R.layout.activity_splash)

    override val presenter: SplashContract.Presenter by instance()

    override fun viewInit() {
        super.viewInit()
        Navigator.login(this)
    }
}