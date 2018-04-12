package com.getlikes.main.tags

import android.os.Bundle
import com.getlikes.core.BasePresenter

class TagsRootPresenter : BasePresenter<TagsRootContract.View>(), TagsRootContract.Presenter {

    override fun attach(view: TagsRootContract.View, bundle: Bundle?) {
        super.attach(view, bundle)

        view.choiceCategory()
    }

}
