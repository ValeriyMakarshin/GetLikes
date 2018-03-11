package com.getlikes.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Data(
    @SerializedName("id") @Expose
    var id: String? = null,

    @SerializedName("user") @Expose
    var user: User? = null,

    @SerializedName("images") @Expose
    var images: Images? = null,

    @SerializedName("created_time") @Expose
    var createdTime: String? = null,

    @SerializedName("caption") @Expose
    var caption: Any? = null,

    @SerializedName("user_has_liked") @Expose
    var userHasLiked: Boolean? = null,

//    @SerializedName("likes") @Expose
//    var likes: Likes? = null,

    @SerializedName("tags") @Expose
    var tags: List<Any>? = null,

    @SerializedName("filter") @Expose
    var filter: String? = null,

//    @SerializedName("comments") @Expose
//    var comments: Comments? = null,

    @SerializedName("type") @Expose
    var type: String? = null,

    @SerializedName("link") @Expose
    var link: String? = null,

    @SerializedName("location") @Expose
    var location: Any? = null,

    @SerializedName("attribution") @Expose
    var attribution: Any? = null,

    @SerializedName("users_in_photo") @Expose
    var usersInPhoto: List<Any>? = null
)
