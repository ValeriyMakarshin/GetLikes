package com.getlikes.model.edit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class EditModel(
    @SerializedName("form_data") @Expose
    var formData: FormData? = null
)
