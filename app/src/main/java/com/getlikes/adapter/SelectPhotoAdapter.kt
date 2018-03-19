package com.getlikes.adapter

import android.view.ViewGroup
import com.getlikes.adapter.holder.selectphoto.SelectPhotoBaseHolder
import com.getlikes.adapter.holder.selectphoto.SelectPhotoHeader
import com.getlikes.adapter.holder.selectphoto.SelectPhotoHolder
import com.getlikes.core.BaseRAdapter
import dev.niekirk.com.instagram4android.requests.payload.InstagramFeedItem

class SelectPhotoAdapter(array: Array<InstagramFeedItem>) :
    BaseRAdapter<InstagramFeedItem, SelectPhotoBaseHolder>(array) {
    companion object {
        const val ITEM_VIEW_TYPE_HEADER = 1
        const val ITEM_VIEW_TYPE_ITEM = 2
    }

    fun isHeader(position: Int): Boolean = position == 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectPhotoBaseHolder =
        when (viewType) {
            ITEM_VIEW_TYPE_HEADER -> SelectPhotoHeader.creator().invoke(parent)
            ITEM_VIEW_TYPE_ITEM   -> SelectPhotoHolder.creator().invoke(parent)
            else                  -> throw IllegalArgumentException("Unknown viewType holder")
        }

    override fun onBindViewHolder(holder: SelectPhotoBaseHolder, position: Int) {
        if (isHeader(position)) return

        holder.setData(items[position - 1])
        holder.setClickListener(onClickListener)
    }

    override fun getItemViewType(position: Int): Int =
        if (isHeader(position))
            ITEM_VIEW_TYPE_HEADER
        else
            ITEM_VIEW_TYPE_ITEM

    override fun getItemCount(): Int {
        return super.getItemCount() + 1
    }
}

