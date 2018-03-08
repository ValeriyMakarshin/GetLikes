package com.getlikes.core

import me.dmdev.rxpm.base.PmSupportFragment

abstract class BaseFragment<PM : BasePresentationModel> : PmSupportFragment<PM>() {
    override fun onBindPresentationModel(pm: PM) {

    }
}