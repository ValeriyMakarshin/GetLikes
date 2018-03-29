package com.getlikes.adapter

import com.getlikes.adapter.holder.rate.RateBaseHolder
import com.getlikes.adapter.holder.rate.RateHeader
import com.getlikes.adapter.holder.rate.RateHolder
import com.getlikes.core.BaseRHeaderAdapter
import com.getlikes.core.OnClickListener
import com.getlikes.main.choice.photo.rate.Rates
import dev.niekirk.com.instagram4android.requests.payload.InstagramFeedItem

class RateAdapter(array: Array<Rates>, feedItem: InstagramFeedItem,
                  onClickListener: OnClickListener<Rates>) :
    BaseRHeaderAdapter<Rates, RateBaseHolder>(array,
        RateHeader.creator(feedItem),
        RateHolder.creator(),
        onClickListener)
