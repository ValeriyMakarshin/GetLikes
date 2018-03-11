package com.getlikes.start

import com.getlikes.core.BasePresenter

class StartPresenter : BasePresenter<StartContract.View>(), StartContract.Presenter {
    override fun getStart() {
        view?.goToLogin()
    }
}
