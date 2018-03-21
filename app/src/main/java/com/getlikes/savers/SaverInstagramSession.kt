package com.getlikes.savers

import com.getlikes.network.InstagramApi
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class SaverInstagramSession {
    companion object {
        fun fromInstagrammApi(instagramApi: InstagramApi): SaverInstagramSession {
            val saver = SaverInstagramSession()
            saver.deviceId = instagramApi.deviceId
            saver.username = instagramApi.username
            saver.password = instagramApi.password
            saver.accessToken = instagramApi.accessToken
            saver.isLoggedIn = instagramApi.isLoggedIn
            saver.uuid = instagramApi.uuid
            saver.rankToken = instagramApi.rankToken
            saver.userId = instagramApi.userId
            return saver
        }
    }

    @SerializedName("deviceId") @Expose
    var deviceId: String? = null

    @SerializedName("username") @Expose
    var username: String? = null

    @SerializedName("password") @Expose
    var password: String? = null

    @SerializedName("accessToken") @Expose
    var accessToken: String? = null

    @SerializedName("isLoggedIn") @Expose
    var isLoggedIn: Boolean = false

    @SerializedName("uuid") @Expose
    var uuid: String? = null

    @SerializedName("rankToken") @Expose
    var rankToken: String? = null

    @SerializedName("userId") @Expose
    var userId: Long = 0


    fun toInstagrammApi(): InstagramApi {
        val instagramApi = InstagramApi()
        instagramApi.deviceId = deviceId
        instagramApi.username = username
        instagramApi.password = password
        instagramApi.accessToken = accessToken
        instagramApi.setIsLoggedIn(isLoggedIn)
        instagramApi.uuid = uuid
        instagramApi.rankToken = rankToken
        instagramApi.userId = userId
        return instagramApi
    }
}
