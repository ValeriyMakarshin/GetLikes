package com.getlikes.main.choice.photo.rate

import android.os.Bundle
import com.getlikes.core.BasePresenter

class ChoiceRatePresenter : BasePresenter<ChoiceRateContract.View>(),
    ChoiceRateContract.Presenter {
    override fun attach(view: ChoiceRateContract.View, bundle: Bundle?) {
        super.attach(view, bundle)

        view.showList(Rates.values())
    }
}
