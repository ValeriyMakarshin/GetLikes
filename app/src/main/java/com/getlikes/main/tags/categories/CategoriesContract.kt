package com.getlikes.main.tags.categories

import com.getlikes.core.BaseContract
import com.getlikes.model.Category

interface CategoriesContract {
    interface View : BaseContract.View {
        fun showList(categories: ArrayList<Category>)
    }

    interface Presenter : BaseContract.Presenter<View>

}
