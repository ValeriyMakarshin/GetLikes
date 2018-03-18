package com.getlikes.main.choice

import android.util.Log
import com.getlikes.core.BasePresenter

class ChoicePresenter(private val interactor: ChoiceInteractor) :
    BasePresenter<ChoiceContract.View>(), ChoiceContract.Presenter {

    override fun loadData() {
        baseObservable(interactor.getPhoto(),
            {
                Log.i("132", "loadList")
                it.items
            })
    }
}
