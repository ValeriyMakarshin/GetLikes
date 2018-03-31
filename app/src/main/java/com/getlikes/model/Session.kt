package com.getlikes.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Session(
    @Expose @SerializedName("session_id")
    val sessionId: String
) : Data
