package com.getlikes.main.earncoins

import android.util.Log
import com.getlikes.core.BasePresenter

class EarnCoinsPresenter(val earnCoinsInteractor: EarnCoinsInteractor) :
    BasePresenter<EarnCoinsContract.View>(), EarnCoinsContract.Presenter {

    override fun loadData() {
        super.loadData()

        getTask()
    }

    private fun getTask() {
        baseObservable(earnCoinsInteractor.getTask(), {
            Log.i("132", "132")
        }, {
            Log.i("132", "132")
        })
    }
}
