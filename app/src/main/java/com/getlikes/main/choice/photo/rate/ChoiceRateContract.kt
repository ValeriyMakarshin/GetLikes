package com.getlikes.main.choice.photo.rate

import com.getlikes.core.BaseContract

interface ChoiceRateContract {
    interface View : BaseContract.View {
        fun showList(list: List<Rates>)
    }

    interface Presenter : BaseContract.Presenter<View>
}
