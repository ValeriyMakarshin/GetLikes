package com.getlikes.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class TagGroup(
    @Expose @SerializedName("categories")
    val categories: Category
)
