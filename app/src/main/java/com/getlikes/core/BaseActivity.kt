package com.getlikes.core

import android.os.Bundle
import android.support.annotation.CallSuper
import com.arellomobile.mvp.MvpAppCompatActivity

abstract class BaseActivity<V : BaseContract.View, P : BaseContract.Presenter<V>> :
    MvpAppCompatActivity(), BaseContract.View {

    abstract val activityInfo: ActivityInfo

    lateinit var presenter: P

    @CallSuper
    @Suppress("UNCHECKED_CAST")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activityInfo.layoutId)

        activityInfo.toolbar?.let { setSupportActionBar(it) }

        if (needShowHomeButton()) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.setHomeButtonEnabled(true)
        }


        viewInit()
    }

    open fun needShowHomeButton(): Boolean = true

    protected open fun viewInit() {
    }

}
