package com.getlikes.main.di

import com.getlikes.main.earncoins.EarnCoinsContract
import com.getlikes.main.earncoins.EarnCoinsInteractor
import com.getlikes.main.earncoins.EarnCoinsInteractorImpl
import com.getlikes.main.earncoins.EarnCoinsPresenter
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.singleton

class EarnCoinsKodein {
    companion object {
        fun initModule() = Kodein.Module {
            bind<EarnCoinsInteractor>() with singleton {
                EarnCoinsInteractorImpl(instance(), instance())
            }
            bind<EarnCoinsContract.Presenter>() with singleton { EarnCoinsPresenter(instance()) }
        }
    }
}
