package com.getlikes

import android.content.Context
import android.content.Intent
import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import com.getlikes.login.LoginActivity
import com.getlikes.main.MainActivity
import com.getlikes.main.tags.hashtags.HashtagsFragment
import com.getlikes.main.choice.photo.ChoicePhotoFragment
import com.getlikes.main.choice.photo.rate.ChoiceRateFragment
import com.getlikes.model.Category
import com.getlikes.splash.start.StartActivity
import dev.niekirk.com.instagram4android.requests.payload.InstagramFeedItem

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
            openFragment(fragmentManager, ChoicePhotoFragment(), containerViewId)
        }

        fun choiceRate(feedItem: InstagramFeedItem, fragmentManager: FragmentManager?,
                       @IdRes containerViewId: Int) {
            openFragment(fragmentManager, ChoiceRateFragment.newInstance(feedItem),
                containerViewId, true)
        }

        fun hashTags(category: Category,
                     fragmentManager: FragmentManager?, @IdRes containerViewId: Int) {
            openFragment(fragmentManager, HashtagsFragment.newInstance(category), containerViewId)
        }

        private fun openFragment(fragmentManager: FragmentManager?, fragment: Fragment,
                                 @IdRes containerViewId: Int, addInBackStack: Boolean = false) {
            fragmentManager?.run {
                val tag = fragment::class.toString()

                val fragmentTransaction = fragmentManager.beginTransaction()
                    .replace(containerViewId, fragment, tag)

                if (addInBackStack) {
                    fragmentTransaction.addToBackStack(tag)
                }

                fragmentTransaction.commit()
            }
        }
    }
}
