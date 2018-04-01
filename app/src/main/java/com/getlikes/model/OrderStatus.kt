package com.getlikes.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class OrderStatus(
    @Expose @SerializedName("message")
    val message: String
) : Data