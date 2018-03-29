package com.getlikes.adapter

import com.getlikes.adapter.holder.rate.RateBaseHolder
import com.getlikes.adapter.holder.rate.RateHeader
import com.getlikes.adapter.holder.rate.RateHolder
import com.getlikes.core.BaseRHeaderAdapter
import com.getlikes.core.OnClickListener
import com.getlikes.main.choice.photo.rate.Rates

class RateAdapter(array: Array<Rates>, onClickListener: OnClickListener<Rates>) :
    BaseRHeaderAdapter<Rates, RateBaseHolder>(array,
        RateHeader.creator(),
        RateHolder.creator(),
        onClickListener) {

}
