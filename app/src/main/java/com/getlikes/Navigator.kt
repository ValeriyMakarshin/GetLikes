package com.getlikes

import android.content.Context
import android.content.Intent
import com.getlikes.login.LoginActivity


interface Navigator {
    companion object {
        fun login(context: Context) {
            context.startActivity(Intent(context, LoginActivity::class.java))
        }
    }
}
