package com.getlikes.main.di

import com.getlikes.main.tags.CategoriesContract
import com.getlikes.main.tags.CategoriesInteractor
import com.getlikes.main.tags.CategoriesInteractorImpl
import com.getlikes.main.tags.CategoriesPresenter
import com.getlikes.main.tags.hashtags.HashtagsContract
import com.getlikes.main.tags.hashtags.HashtagsPresenter
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.singleton

class TagsKodein {
    companion object {
        fun initModule() = Kodein.Module {
            bind<CategoriesInteractor>() with singleton {
                CategoriesInteractorImpl(instance(), instance())
            }
            bind<CategoriesContract.Presenter>() with singleton { CategoriesPresenter(instance()) }

            bind<HashtagsContract.Presenter>() with singleton { HashtagsPresenter() }
        }
    }
}
