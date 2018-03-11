package com.getlikes.login

import android.annotation.SuppressLint
import android.view.KeyEvent
import com.getlikes.BuildConfig
import com.getlikes.R
import com.getlikes.core.ActivityInfo
import com.getlikes.core.BaseActivity
import com.github.salomonbrys.kodein.instance
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : BaseActivity<LoginContract.View, LoginContract.Presenter>(),
    LoginContract.View {

    override val presenter: LoginContract.Presenter by instance()

    override val activityInfo: ActivityInfo
        get() = ActivityInfo(R.layout.activity_login)

    override fun viewInit() {
        super.viewInit()

        uiLoginBt.setOnClickListener {
            presenter.login(uiLoginEt.text.toString(), uiPasswordEt.text.toString())
        }

        uiLikeBt.setOnClickListener {
            presenter.like()
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (BuildConfig.DEBUG && keyCode == KeyEvent.KEYCODE_VOLUME_DOWN) {
            uiLoginEt.setText("psycho9917@gmail.com")
            uiPasswordEt.setText("q123456")
            return true
        }
        return super.onKeyDown(keyCode, event)
    }

}
