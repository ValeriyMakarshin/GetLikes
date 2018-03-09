package com.getlikes.login

import com.getlikes.R
import com.getlikes.core.ActivityInfo
import com.getlikes.core.BaseActivity

class LoginActivity : BaseActivity<LoginPresentationModel>() {
    override val activityInfo: ActivityInfo
        get() = ActivityInfo(R.layout.activity_login)

    override fun providePresentationModel(): LoginPresentationModel = LoginPresentationModel()

}
