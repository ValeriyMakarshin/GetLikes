package com.getlikes.adapter.holder.rate

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.getlikes.R
import com.getlikes.main.choice.photo.rate.Rates
import dev.niekirk.com.instagram4android.requests.payload.InstagramFeedItem
import kotlinx.android.synthetic.main.view_photo.view.*

class RateHeader(itemView: View, val feedItem: InstagramFeedItem) : RateBaseHolder(itemView) {

    companion object {
        fun creator(feedItem: InstagramFeedItem): (ViewGroup?) -> RateHeader =
            { viewGroup ->
                RateHeader(LayoutInflater.from(viewGroup?.context)
                    .inflate(R.layout.item_rate_header, viewGroup, false), feedItem)
            }
    }

    override fun onDraw(item: Rates) {
        itemView.uiLikesTv.text = feedItem.like_count.toString()
        Glide.with(itemView.context)
            .load(feedItem.image_versions2.candidates.last().url)
            .into(itemView.uiPhotoIv)
    }

}