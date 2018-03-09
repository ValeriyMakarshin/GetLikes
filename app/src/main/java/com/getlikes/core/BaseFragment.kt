package com.getlikes.core

import me.dmdev.rxpm.base.PmSupportFragment

abstract class BaseFragment<PM : BasePresentationModel> : PmSupportFragment<PM>() {
    abstract val activityInfo: ActivityInfo

    override fun onBindPresentationModel(pm: PM) {

    }
}