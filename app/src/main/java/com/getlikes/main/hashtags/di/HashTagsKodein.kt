package com.getlikes.main.di

import com.getlikes.main.hashtags.HashTagsContract
import com.getlikes.main.hashtags.HashTagsPresenter
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.singleton

class HashTagsKodein {
    companion object {
        fun initModule() = Kodein.Module {
            bind<HashTagsContract.Presenter>() with singleton { HashTagsPresenter() }
        }
    }
}
