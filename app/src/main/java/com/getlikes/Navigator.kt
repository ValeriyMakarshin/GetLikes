package com.getlikes

import android.content.Context
import android.content.Intent
import android.support.annotation.IdRes
import android.support.v4.app.FragmentManager
import com.getlikes.login.LoginActivity
import com.getlikes.main.MainActivity
import com.getlikes.main.choice.photo.ChoicePhotoFragment
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

        fun choicePhoto(fragmentManager: FragmentManager?, @IdRes containerViewId: Int) {
            fragmentManager?.run {
                fragmentManager.beginTransaction()
                    .add(containerViewId, ChoicePhotoFragment(),
                        ChoicePhotoFragment::class.toString())
                    .commit()
            }
        }
    }
}
