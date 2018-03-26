package com.getlikes.main.choice.photo

import com.getlikes.core.BasePresenter

class ChoicePhotoPresenter(private val photoInteractor: ChoicePhotoInteractor) :
    BasePresenter<ChoicePhotoContract.View>(), ChoicePhotoContract.Presenter {

    override fun loadData() {
        baseObservable(photoInteractor.getPhoto(),
            {
                view?.showList(it.items)
            })
    }
}
