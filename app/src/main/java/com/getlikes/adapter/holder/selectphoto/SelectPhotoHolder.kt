package com.getlikes.adapter.holder.selectphoto

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.getlikes.R
import dev.niekirk.com.instagram4android.requests.payload.InstagramFeedItem
import kotlinx.android.synthetic.main.item_photo.view.*

class SelectPhotoHolder(itemView: View) : SelectPhotoBaseHolder(itemView) {

    companion object {
        fun creator(): (ViewGroup?) -> SelectPhotoHolder =
            { viewGroup ->
                SelectPhotoHolder(LayoutInflater.from(viewGroup?.context)
                    .inflate(R.layout.item_photo, viewGroup, false))
            }
    }

    override fun onDraw(item: InstagramFeedItem) {
        itemView.uiLikesTv.text = item.like_count.toString()
        Glide.with(itemView.context)
            .load(item.image_versions2.candidates.last().url)
            .into(itemView.uiPhotoIv)
    }
}
