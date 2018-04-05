package com.getlikes.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Subcategory(
    @Expose @SerializedName("name")
    val name: String,

    @Expose @SerializedName("tags")
    val tags: String
)
