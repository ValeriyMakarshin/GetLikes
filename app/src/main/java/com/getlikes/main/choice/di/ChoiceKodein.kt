package com.getlikes.main.choice.di

import com.getlikes.main.choice.photo.ChoicePhotoContract
import com.getlikes.main.choice.photo.ChoicePhotoInteractor
import com.getlikes.main.choice.photo.ChoicePhotoInteractorImpl
import com.getlikes.main.choice.photo.ChoicePhotoPresenter
import com.getlikes.main.choice.photo.rate.ChoiceRateContract
import com.getlikes.main.choice.photo.rate.ChoiceRatePresenter
import com.getlikes.main.choice.root.ChoiceRootContract
import com.getlikes.main.choice.root.ChoiceRootPresenter
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.singleton

class ChoiceKodein {
    companion object {
        fun initModule() = Kodein.Module {
            bind<ChoiceRootContract.Presenter>() with singleton { ChoiceRootPresenter() }

            bind<ChoicePhotoInteractor>() with singleton { ChoicePhotoInteractorImpl(instance()) }
            bind<ChoicePhotoContract.Presenter>() with singleton { ChoicePhotoPresenter(instance()) }

            bind<ChoiceRateContract.Presenter>() with singleton { ChoiceRatePresenter() }
        }
    }
}
