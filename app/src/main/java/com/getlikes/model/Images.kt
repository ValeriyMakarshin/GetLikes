package com.getlikes.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Images(
    @SerializedName("thumbnail") @Expose
    var thumbnail: Resolution? = null,

    @SerializedName("low_resolution") @Expose
    var lowResolution: Resolution? = null,

    @SerializedName("standard_resolution") @Expose
    var standardResolution: Resolution? = null
)