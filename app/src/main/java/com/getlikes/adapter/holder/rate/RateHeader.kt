package com.getlikes.adapter.holder.rate

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.getlikes.R
import com.getlikes.main.choice.photo.rate.Rates

class RateHeader(itemView: View) : RateBaseHolder(itemView) {

    companion object {
        fun creator(): (ViewGroup?) -> RateHeader =
            { viewGroup ->
                RateHeader(LayoutInflater.from(viewGroup?.context)
                    .inflate(R.layout.item_rate_header, viewGroup, false))
            }
    }

    override fun onDraw(item: Rates) {
    }

}