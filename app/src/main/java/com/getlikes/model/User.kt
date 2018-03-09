package com.getlikes.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("id") @Expose
    var id: String? = null,

    @SerializedName("full_name") @Expose
    var fullName: String? = null,

    @SerializedName("profile_picture") @Expose
    var profilePicture: String? = null,

    @SerializedName("username") @Expose
    var username: String? = null,

    @SerializedName("bio") @Expose
    var bio: String? = null,

    @SerializedName("website") @Expose
    var website: String? = null,

    @SerializedName("is_business") @Expose
    var isBusiness: Boolean? = null
)
