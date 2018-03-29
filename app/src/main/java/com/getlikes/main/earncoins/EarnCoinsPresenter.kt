package com.getlikes.main.earncoins

import com.getlikes.core.BasePresenter

class EarnCoinsPresenter(val earnCoinsInteractor: EarnCoinsInteractor) :
    BasePresenter<EarnCoinsContract.View>(), EarnCoinsContract.Presenter {

    override fun loadData() {
        super.loadData()

        getTask()
    }

    fun getTask() {
        earnCoinsInteractor.getTask()
    }
}