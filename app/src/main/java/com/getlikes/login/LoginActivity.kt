package com.getlikes.login

import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
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

        uiLoginWv.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                return super.shouldOverrideUrlLoading(view, request)
            }
        }
    }

    override fun openWebView(loginUrl: String) {
        uiLoginWv.loadUrl(loginUrl)
    }
}
