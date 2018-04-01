package com.getlikes.login

import android.annotation.SuppressLint
import android.view.KeyEvent
import com.getlikes.BuildConfig
import com.getlikes.Navigator
import com.getlikes.R
import com.getlikes.core.ActivityInfo
import com.getlikes.core.BaseActivity
import com.getlikes.util.Strings
import com.github.salomonbrys.kodein.instance
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity<LoginContract.View, LoginContract.Presenter>(),
    LoginContract.View {

    override val presenter: LoginContract.Presenter by instance()

    override val activityInfo: ActivityInfo = ActivityInfo(R.layout.activity_login)

    override fun viewInit() {
        super.viewInit()

        uiLoginBt.setOnClickListener {
            presenter.loginInstagram(uiLoginEt.text.toString(), uiPasswordEt.text.toString())
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (BuildConfig.DEBUG && keyCode == KeyEvent.KEYCODE_VOLUME_DOWN) {
            val psycho = "psycho9917@gmail.com"
            val lopata = "lopata9917@yandex.ru"
            val password = "q123456"

            val username = uiLoginEt.text.toString()

            uiLoginEt.setText(when (username) {
                Strings.EMPTY -> psycho
                psycho -> lopata
                else -> Strings.EMPTY
            })

            uiPasswordEt.setText(password)
            return true
        }
        return super.onKeyDown(keyCode, event)
    }

    override fun goToMain() {
        Navigator.mainScreen(this)
    }
}
