package com.getlikes.main.choice

import com.getlikes.core.BasePresenter

class ChoicePresenter(private val interactor: ChoiceInteractor) :
    BasePresenter<ChoiceContract.View>(), ChoiceContract.Presenter {

    override fun loadData() {
        baseObservable(interactor.getPhoto(),
            {
                view?.showList(it.items)
            })
    }
}
