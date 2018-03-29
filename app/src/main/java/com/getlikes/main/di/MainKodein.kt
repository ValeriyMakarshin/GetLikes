package com.getlikes.main.di

import com.getlikes.main.MainContract
import com.getlikes.main.MainPresenter
import com.getlikes.main.choice.di.ChoiceKodein
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.singleton

class MainKodein {
    companion object {
        fun initModule() = Kodein.Module {
            import(ChoiceKodein.initModule())
            import(EarnCoinsKodein.initModule())
            import(HashTagsKodein.initModule())

            bind<MainContract.Presenter>() with singleton { MainPresenter() }
        }
    }
}
