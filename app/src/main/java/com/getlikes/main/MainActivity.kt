package com.getlikes.main

import com.getlikes.R
import com.getlikes.core.ActivityInfo
import com.getlikes.core.BaseActivity

class MainActivity : BaseActivity<MainPresentationModel>() {
    override val activityInfo: ActivityInfo
        get() = ActivityInfo(R.layout.activity_main)

    override fun providePresentationModel(): MainPresentationModel = MainPresentationModel()


//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//    }
}
