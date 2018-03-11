package com.getlikes.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Block(
//    @SerializedName("pagination") @Expose
//    var pagination: Pagination? = null,

    @SerializedName("data") @Expose
    var data: List<Data>? = null

//    @SerializedName("meta") @Expose
//    var meta: Meta? = null
)
