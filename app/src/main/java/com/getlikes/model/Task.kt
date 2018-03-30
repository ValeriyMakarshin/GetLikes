package com.getlikes.model

import com.getlikes.util.Strings
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Task(
    @Expose @SerializedName("media_id")
    val mediaId: String = Strings.EMPTY
) : Data
