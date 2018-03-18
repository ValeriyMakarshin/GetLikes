package com.getlikes

import android.content.Context
import android.content.Intent
import com.getlikes.login.LoginActivity
import com.getlikes.main.MainActivity


interface Navigator {
    companion object {
        fun mainScreen(context: Context) {
            context.startActivity(Intent(context, MainActivity::class.java))
        }

        fun login(context: Context) {
            context.startActivity(Intent(context, LoginActivity::class.java))
        }
    }
}
