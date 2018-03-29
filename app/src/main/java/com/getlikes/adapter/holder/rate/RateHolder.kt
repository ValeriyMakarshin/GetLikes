package com.getlikes.adapter.holder.rate

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.getlikes.R
import com.getlikes.main.choice.photo.rate.Rates

class RateHolder(itemView: View) : RateBaseHolder(itemView) {
    companion object {
        fun creator(): (ViewGroup?) -> RateHolder =
            { viewGroup ->
                RateHolder(LayoutInflater.from(viewGroup?.context)
                    .inflate(R.layout.item_select_header, viewGroup, false))
            }
    }

    override fun onDraw(item: Rates) {
    }
}