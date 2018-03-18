package com.getlikes.adapter.holder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.getlikes.R
import com.getlikes.core.BaseHolder
import dev.niekirk.com.instagram4android.requests.payload.InstagramFeedItem

class SelectPhotoHolder(itemView: View) : BaseHolder<InstagramFeedItem>(itemView) {

    companion object {
        fun creator(): (ViewGroup?) -> SelectPhotoHolder =
            { viewGroup ->
                SelectPhotoHolder(LayoutInflater.from(viewGroup?.context)
                    .inflate(R.layout.item_photo, viewGroup, false))
            }
    }

    override fun onDraw(item: InstagramFeedItem) {

    }
}
