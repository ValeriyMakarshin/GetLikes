package com.getlikes.main.di

import com.getlikes.main.earncoins.EarnCoinsContract
import com.getlikes.main.earncoins.EarnCoinsPresenter
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.singleton

class EarnCoinsKodein {
    companion object {
        fun initModule() = Kodein.Module {
            bind<EarnCoinsContract.Presenter>() with singleton { EarnCoinsPresenter() }
        }
    }
}
