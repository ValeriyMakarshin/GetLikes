package com.getlikes.main.earncoins

import com.getlikes.R
import com.getlikes.core.BasePresenter
import com.getlikes.model.Status

class EarnCoinsPresenter(val earnCoinsInteractor: EarnCoinsInteractor) :
    BasePresenter<EarnCoinsContract.View>(), EarnCoinsContract.Presenter {

    override fun loadData() {
        super.loadData()

        getTask()
    }

    private fun getTask() {
        baseObservable(earnCoinsInteractor.getTask(), {
            when (it.status) {
                Status.ERROR -> {
                    view?.showMessage(R.string.message_no_task)
                }
                Status.OK -> {
                }


            }
        })
    }
}
