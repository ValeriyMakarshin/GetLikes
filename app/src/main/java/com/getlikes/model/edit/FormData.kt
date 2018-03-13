package com.getlikes.model.edit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class FormData(
    @SerializedName("first_name") @Expose
    var firstName: String? = null,

    @SerializedName("last_name") @Expose
    var lastName: String? = null,

    @SerializedName("email") @Expose
    var email: String? = null,

    @SerializedName("username") @Expose
    var username: String? = null,

    @SerializedName("phone_number") @Expose
    var phoneNumber: String? = null,

    @SerializedName("gender") @Expose
    var gender: Int? = null,

    @SerializedName("biography") @Expose
    var biography: String? = null,

    @SerializedName("external_url") @Expose
    var externalUrl: String? = null,

    @SerializedName("chaining_enabled") @Expose
    var chainingEnabled: Boolean? = null,

    @SerializedName("private_account") @Expose
    var privateAccount: Boolean? = null,

    @SerializedName("business_account") @Expose
    var businessAccount: Boolean? = null
)