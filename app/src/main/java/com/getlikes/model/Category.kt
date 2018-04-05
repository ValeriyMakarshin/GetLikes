package com.getlikes.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Category(
    @Expose @SerializedName("name")
    val name: String,

    @Expose @SerializedName("subcategories")
    val subcategories: ArrayList<Subcategory>
)
