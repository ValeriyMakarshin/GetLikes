package com.getlikes.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Task(
    @Expose @SerializedName("media_id")
    val mediaId: String,
    @Expose @SerializedName("thumbnail_url")
    val thumbnailUrl: String,
    @Expose @SerializedName("standard_resolution_url")
    val standardResolutionUrl: String
) : Data
