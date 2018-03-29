package com.getlikes.adapter

import android.view.ViewGroup
import com.getlikes.adapter.holder.RateHolder
import com.getlikes.core.BaseRAdapter
import com.getlikes.core.OnClickListener
import com.getlikes.main.choice.photo.rate.Rates

class RateAdapter(array: Array<Rates>, onClickListener: OnClickListener<Rates>) :
    BaseRAdapter<Rates, RateHolder>(array, onClickListener = onClickListener) {

    override fun getItemCount(): Int {
        return super.getItemCount()
    }

    override fun onBindViewHolder(holder: RateHolder, position: Int) {
        super.onBindViewHolder(holder, position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RateHolder {
        return super.onCreateViewHolder(parent, viewType)
    }
}