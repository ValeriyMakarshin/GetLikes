package com.getlikes.core

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.annotation.CallSuper
import com.github.salomonbrys.kodein.android.KodeinAppCompatActivity

abstract class BaseActivity<in V : BaseContract.View, out P : BaseContract.Presenter<V>> :
    KodeinAppCompatActivity(), BaseContract.View {

    abstract val activityInfo: ActivityInfo

    abstract val presenter: P

    @SuppressLint("MissingSuperCall")
    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activityInfo.layoutId)

        presenter.attach(this as V, intent.extras)

        activityInfo.toolbar?.let { setSupportActionBar(it) }

        if (needShowHomeButton()) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.setHomeButtonEnabled(true)
        }


        viewInit()
    }

    open fun needShowHomeButton(): Boolean = false

    protected open fun viewInit() {
    }

    @SuppressLint("MissingSuperCall")
    override fun onDestroy() {
        presenter.detach()
        super.onDestroy()
    }

    override fun showError(throwable: Throwable) {
    }

    override fun showProgress() {
    }

    override fun hideProgress() {
    }
}
