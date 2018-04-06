package com.getlikes.main.di

import com.getlikes.main.hashtags.HashTagsContract
import com.getlikes.main.hashtags.HashTagsInteractor
import com.getlikes.main.hashtags.HashTagsInteractorImpl
import com.getlikes.main.hashtags.HashTagsPresenter
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.singleton

class HashTagsKodein {
    companion object {
        fun initModule() = Kodein.Module {
            bind<HashTagsInteractor>() with singleton {
                HashTagsInteractorImpl(instance(), instance())
            }
            bind<HashTagsContract.Presenter>() with singleton { HashTagsPresenter(instance()) }
        }
    }
}
