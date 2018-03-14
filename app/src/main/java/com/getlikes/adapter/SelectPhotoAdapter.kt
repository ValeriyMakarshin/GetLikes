package com.getlikes.adapter

import com.getlikes.adapter.holder.SelectPhotoHolder
import com.getlikes.core.BaseRAdapter

class SelectPhotoAdapter(array: Array<Any>) :
    BaseRAdapter<Any, SelectPhotoHolder>(array, SelectPhotoHolder.creator())

