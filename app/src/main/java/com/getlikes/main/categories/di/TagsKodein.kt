package com.getlikes.main.di

import com.getlikes.main.categories.CategoriesContract
import com.getlikes.main.categories.CategoriesInteractor
import com.getlikes.main.categories.CategoriesInteractorImpl
import com.getlikes.main.categories.CategoriesPresenter
import com.getlikes.main.categories.hashtags.HashtagsContract
import com.getlikes.main.categories.hashtags.HashtagsPresenter
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
