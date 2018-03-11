package com.getlikes.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AccessToken(
    @SerializedName("access_token") @Expose
    var accessToken: String? = null,

    @SerializedName("user") @Expose
    var user: User? = null
)
