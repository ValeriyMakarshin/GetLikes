package com.getlikes.adapter.holder.selectphoto

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.getlikes.R
import dev.niekirk.com.instagram4android.requests.payload.InstagramFeedItem

class SelectPhotoHeader(itemView: View) : SelectPhotoBaseHolder(itemView) {

    companion object {
        fun creator(): (ViewGroup?) -> SelectPhotoHeader =
            { viewGroup ->
                SelectPhotoHeader(LayoutInflater.from(viewGroup?.context)
                    .inflate(R.layout.item_photo_header, viewGroup, false))
            }
    }

    override fun onDraw(item: InstagramFeedItem) {
    }
}
