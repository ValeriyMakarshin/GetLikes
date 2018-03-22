package com.getlikes

import android.content.Context
import android.content.Intent
import com.getlikes.login.LoginActivity
import com.getlikes.main.MainActivity
import com.getlikes.start.StartActivity


interface Navigator {
    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, StartActivity::class.java))
        }

        fun login(context: Context) {
            context.startActivity(Intent(context, LoginActivity::class.java))
        }

        fun mainScreen(context: Context) {
            context.startActivity(Intent(context, MainActivity::class.java))
        }
    }
}
