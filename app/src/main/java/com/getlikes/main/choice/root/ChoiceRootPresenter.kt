package com.getlikes.main.choice.root

import android.os.Bundle
import com.getlikes.core.BasePresenter

class ChoiceRootPresenter : BasePresenter<ChoiceRootContract.View>(), ChoiceRootContract.Presenter {
    override fun attach(view: ChoiceRootContract.View, bundle: Bundle?) {
        super.attach(view, bundle)

        view.openFirst()
    }
}
