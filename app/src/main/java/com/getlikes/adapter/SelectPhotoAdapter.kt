package com.getlikes.adapter

import com.getlikes.adapter.holder.SelectPhotoHolder
import com.getlikes.core.BaseRAdapter
import com.getlikes.model.Photo

class SelectPhotoAdapter(array: Array<Photo>) :
    BaseRAdapter<Photo, SelectPhotoHolder>(array, SelectPhotoHolder.creator())

