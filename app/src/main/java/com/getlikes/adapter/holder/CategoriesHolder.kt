package com.getlikes.adapter.holder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.getlikes.R
import com.getlikes.core.BaseHolder
import com.getlikes.model.Category

class CategoriesHolder(itemView: View) : BaseHolder<Category>(itemView) {
    companion object {
        fun creator(): (ViewGroup?) -> CategoriesHolder =
            { viewGroup ->
                CategoriesHolder(LayoutInflater.from(viewGroup?.context)
                    .inflate(R.layout.item_category, viewGroup, false))
            }
    }

    override fun onDraw(item: Category) {
    }

}