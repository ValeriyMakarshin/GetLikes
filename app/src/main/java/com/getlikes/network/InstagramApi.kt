package com.getlikes.network

import com.getlikes.util.Strings
import dev.niekirk.com.instagram4android.Instagram4Android

class InstagramApi :
    Instagram4Android(Strings.EMPTY, Strings.EMPTY) {

    fun setDeviceId(deviceId: String) {
        this.deviceId = deviceId
    }

    fun setUuid(uuid: String) {
        this.uuid = uuid
    }

    fun setIsLoggedIn(isLoggedIn: Boolean) {
        this.isLoggedIn = isLoggedIn
    }


}
