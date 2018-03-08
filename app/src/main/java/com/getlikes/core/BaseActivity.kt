package com.getlikes.core

import android.annotation.SuppressLint
import android.os.Bundle
import me.dmdev.rxpm.base.PmSupportActivity

abstract class BaseActivity<PM : BasePresentationModel> : PmSupportActivity<PM>() {
    abstract val activityInfo: ActivityInfo

    override fun onBindPresentationModel(pm: PM) {
    }

    @SuppressLint("MissingSuperCall")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activityInfo.layoutId)
    }

}
