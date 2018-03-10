package com.getlikes.core

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class BaseFragment<in V : BaseContract.View, P : BaseContract.Presenter<V>> :
    Fragment() {

    abstract val activityInfo: ActivityInfo

    lateinit var presenter: P

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? =
        inflater.inflate(activityInfo.layoutId, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewInit()

        presenter.attach(this as V, arguments)
    }

    protected open fun viewInit() {
    }

    override fun onDestroyView() {
        presenter.detach()
        super.onDestroyView()
    }
}