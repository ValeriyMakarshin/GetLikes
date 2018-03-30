package com.getlikes.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Answer<out D : Data>(
    @Expose @SerializedName("status")
    val status: Status,

    @Expose @SerializedName("error")
    val error: String,

    @Expose @SerializedName("data")
    val data: D?
)
