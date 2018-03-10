package com.getlikes.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment


abstract class BaseFragment<V : BaseContract.View, P : BaseContract.Presenter<V>> :
    MvpAppCompatFragment() {

    abstract val activityInfo: ActivityInfo

    lateinit var presenter: P

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? =
        inflater.inflate(activityInfo.layoutId, container, false)
}