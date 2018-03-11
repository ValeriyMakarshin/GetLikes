package com.getlikes.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Authenticity(
    @SerializedName("authenticated") @Expose
    var authenticated: Boolean? = null,

    @SerializedName("user") @Expose
    var user: Boolean? = null,

    @SerializedName("status") @Expose
    var status: String? = null
)
