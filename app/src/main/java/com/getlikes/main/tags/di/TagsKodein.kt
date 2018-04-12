package com.getlikes.main.di

import com.getlikes.main.tags.TagsRootContract
import com.getlikes.main.tags.TagsRootPresenter
import com.getlikes.main.tags.categories.CategoriesContract
import com.getlikes.main.tags.categories.CategoriesInteractor
import com.getlikes.main.tags.categories.CategoriesInteractorImpl
import com.getlikes.main.tags.categories.CategoriesPresenter
import com.getlikes.main.tags.hashtags.HashtagsContract
import com.getlikes.main.tags.hashtags.HashtagsPresenter
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.singleton

class TagsKodein {
    companion object {
        fun initModule() = Kodein.Module {
            bind<TagsRootContract.Presenter>() with singleton { TagsRootPresenter() }

            bind<CategoriesInteractor>() with singleton {
                CategoriesInteractorImpl(instance(), instance())
            }
            bind<CategoriesContract.Presenter>() with singleton { CategoriesPresenter(instance()) }

            bind<HashtagsContract.Presenter>() with singleton { HashtagsPresenter() }
        }
    }
}
