package com.getlikes.core

import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity

abstract class BaseActivity<V : BaseContract.View, P : BaseContract.Presenter<V>> :
    MvpAppCompatActivity(), BaseContract.View {

    abstract val activityInfo: ActivityInfo

    lateinit var presenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activityInfo.layoutId)
    }

}
