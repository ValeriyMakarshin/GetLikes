package com.getlikes.adapter.holder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.getlikes.R
import com.getlikes.core.BaseHolder
import com.getlikes.model.Photo

class SelectPhotoHolder(itemView: View) : BaseHolder<Photo>(itemView) {
    companion object {
        fun creator(): (ViewGroup?) -> SelectPhotoHolder =
            { viewGroup ->
                SelectPhotoHolder(LayoutInflater.from(viewGroup?.context)
                    .inflate(R.layout.item_photo, viewGroup, false))
            }
    }

    override fun onDraw(item: Photo) {
    }
}
