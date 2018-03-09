package com.getlikes.adapter

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.getlikes.R
import com.getlikes.core.BaseFragment
import com.getlikes.main.choice.ChoiceFragment
import com.getlikes.main.earncoins.EarnCoinsFragment
import com.getlikes.main.hashtags.HashTagsFragment


class MainPagerAdapter(private val fm: FragmentManager,
                       private val context: Context) :
    FragmentPagerAdapter(fm) {

    companion object {
        val TITLES = intArrayOf(R.string.get_likes, R.string.hash_tags, R.string.earn_coins)
    }

    private val fragments: Array<BaseFragment<*>>

    init {
        fragments = if (fm.fragments == null) {
            arrayOf(
                ChoiceFragment(),
                HashTagsFragment(),
                EarnCoinsFragment())
        } else {
            arrayOf(
                getFragmentFromManager(ChoiceFragment::class.java) as BaseFragment<*>,
                getFragmentFromManager(HashTagsFragment::class.java) as BaseFragment<*>,
                getFragmentFromManager(EarnCoinsFragment::class.java) as BaseFragment<*>)
        }

    }

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int {
        return TITLES.size
    }

    override fun getPageTitle(position: Int): String? {
        return context.getString(TITLES[position])
    }

    private fun getFragmentFromManager(clazz: Class<*>): Fragment? {
        fm.fragments?.let {
            for (fragment in it) {
                if (clazz.isInstance(fragment)) {
                    return fragment
                }
            }
        }
        return null
    }

}
