package com.getlikes.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import me.dmdev.rxpm.base.PmSupportFragment


abstract class BaseFragment<PM : BasePresentationModel> : PmSupportFragment<PM>() {
    abstract val activityInfo: ActivityInfo

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? =
        inflater.inflate(activityInfo.layoutId, container, false)

    override fun onBindPresentationModel(pm: PM) {

    }
}