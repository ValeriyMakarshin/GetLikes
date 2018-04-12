package com.getlikes.main.categories

import com.crashlytics.android.Crashlytics
import com.getlikes.core.BasePresenter

class CategoriesPresenter(val categoriesInteractor: CategoriesInteractor) :
    BasePresenter<CategoriesContract.View>(), CategoriesContract.Presenter {

    override fun loadData() {
        baseSingle(categoriesInteractor.getTagGroup(), {
            view?.showList(it.categories)
        }, {
            Crashlytics.logException(it)
        })
    }

}
