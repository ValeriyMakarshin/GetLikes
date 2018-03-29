package com.getlikes.adapter

import com.getlikes.adapter.holder.selectphoto.SelectPhotoBaseHolder
import com.getlikes.adapter.holder.selectphoto.SelectPhotoHeader
import com.getlikes.adapter.holder.selectphoto.SelectPhotoHolder
import com.getlikes.core.BaseRHeaderAdapter
import com.getlikes.core.OnClickListener
import dev.niekirk.com.instagram4android.requests.payload.InstagramFeedItem

class SelectPhotoAdapter(array: Array<InstagramFeedItem>,
                         onClickListener: OnClickListener<InstagramFeedItem>) :
    BaseRHeaderAdapter<InstagramFeedItem, SelectPhotoBaseHolder>(array,
        SelectPhotoHeader.creator(),
        SelectPhotoHolder.creator(),
        onClickListener)
