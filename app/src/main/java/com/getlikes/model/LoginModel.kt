package com.getlikes.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LoginModel(
    @Expose @SerializedName("username")
    val username: String,

    @Expose @SerializedName("user_id")
    val userId: String
)