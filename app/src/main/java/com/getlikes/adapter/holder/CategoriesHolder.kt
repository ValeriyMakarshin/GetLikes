package com.getlikes.adapter.holder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.getlikes.R
import com.getlikes.core.BaseHolder
import com.getlikes.model.Category
import kotlinx.android.synthetic.main.item_category.view.*

class CategoriesHolder(itemView: View) : BaseHolder<Category>(itemView) {
    companion object {
        fun creator(): (ViewGroup?) -> CategoriesHolder =
            { viewGroup ->
                CategoriesHolder(LayoutInflater.from(viewGroup?.context)
                    .inflate(R.layout.item_category, viewGroup, false))
            }
    }

    override fun onDraw(item: Category) {
        itemView.uiNameTv.text = item.name
    }

}