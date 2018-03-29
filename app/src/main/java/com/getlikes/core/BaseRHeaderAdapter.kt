package com.getlikes.core

import android.view.ViewGroup

abstract class BaseRHeaderAdapter<T : Any, VH : BaseHolder<T>>(
    array: Array<T>,
    private val creatorHeader: ((ViewGroup?) -> VH),
    private val creatorItem: ((ViewGroup?) -> VH),
    onClickListener: OnClickListener<T>? = null) :

    BaseRAdapter<T, VH>(array, onClickListener = onClickListener) {

    companion object {
        const val ITEM_VIEW_TYPE_HEADER = 1
        const val ITEM_VIEW_TYPE_ITEM = 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH =
        when (viewType) {
            ITEM_VIEW_TYPE_HEADER -> creatorHeader.invoke(parent)
            ITEM_VIEW_TYPE_ITEM   -> creatorItem.invoke(parent)
            else                  ->
                throw IllegalArgumentException("Unknown viewType holder")
        }

    override fun getItemCount(): Int = super.getItemCount() + 1

    open fun isHeader(position: Int): Boolean = position == 0

    override fun getItemViewType(position: Int): Int =
        if (isHeader(position))
            ITEM_VIEW_TYPE_HEADER
        else
            ITEM_VIEW_TYPE_ITEM

    override fun onBindViewHolder(holder: VH, position: Int) {
        if (isHeader(position)) return

        holder.setData(items[position - 1])
        holder.setClickListener(onClickListener)
    }
}
