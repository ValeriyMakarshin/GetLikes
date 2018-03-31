package com.getlikes.model.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Order(
    @Expose @SerializedName("session_id")
    var sessionId: String,
    @Expose @SerializedName("thumbnail_url")
    val thumbnailUrl: String,
    @Expose @SerializedName("standard_resolution_url")
    val standardResolutionUrl: String,
    @Expose @SerializedName("amount")
    val amount: Int
)
