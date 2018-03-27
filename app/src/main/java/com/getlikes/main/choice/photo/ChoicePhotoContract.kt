package com.getlikes.main.choice.photo

import com.getlikes.core.BaseContract
import dev.niekirk.com.instagram4android.requests.payload.InstagramFeedItem

interface ChoicePhotoContract {
    interface View : BaseContract.View {
        fun showList(list: List<InstagramFeedItem>)

        fun choiceRate()
    }

    interface Presenter : BaseContract.Presenter<View>
}
