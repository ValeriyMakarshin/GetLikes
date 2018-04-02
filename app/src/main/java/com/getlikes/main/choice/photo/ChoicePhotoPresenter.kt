package com.getlikes.main.choice.photo

import com.getlikes.core.BasePresenter

class ChoicePhotoPresenter(private val choicePhotoInteractor: ChoicePhotoInteractor) :
    BasePresenter<ChoicePhotoContract.View>(), ChoicePhotoContract.Presenter {

    override fun loadData() {
        baseObservable(choicePhotoInteractor.getPhoto(),
            {
                view?.showList(it.items)
            })
    }
}
