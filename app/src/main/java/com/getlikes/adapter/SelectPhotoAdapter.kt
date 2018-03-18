package com.getlikes.adapter

import com.getlikes.adapter.holder.SelectPhotoHolder
import com.getlikes.core.BaseRAdapter
import dev.niekirk.com.instagram4android.requests.payload.InstagramFeedItem

class SelectPhotoAdapter(array: Array<InstagramFeedItem>) :
    BaseRAdapter<InstagramFeedItem, SelectPhotoHolder>(array, SelectPhotoHolder.creator())

