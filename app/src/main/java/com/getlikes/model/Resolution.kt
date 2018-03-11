package com.getlikes.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Resolution(
    @SerializedName("width") @Expose
    var width: Int? = null,

    @SerializedName("height") @Expose
    var height: Int? = null,

    @SerializedName("url") @Expose
    var url: String? = null
)
