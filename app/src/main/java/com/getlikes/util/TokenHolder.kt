package com.getlikes.util

import com.getlikes.network.InstagramApi
import com.getlikes.savers.SaverInstagramSession
import com.getlikes.util.storage.Storage

class TokenHolder(private val storage: Storage) {
    companion object {
        const val KEY_LOGIN = "key_login"
        const val KEY_PASSWORD = "key_password"

        const val KEY_LOGGED_USER = "key_logged_user"

        val KEY_USER_ID = "key_user_id"

        private const val KEY_INSTAGRAM_OBJECT = "key_instagram_object"

        private const val KEY_TOKEN = "key_token"
        private const val KEY_EMAIL = "key_email"
        private const val KEY_ID = "key_id"
    }

    val email: String?
        get() = storage.getString(KEY_EMAIL)

    val id: String?
        get() = storage.getString(KEY_ID)

    fun saveSession(instagramApi: InstagramApi) {
        clean()

        storage.putObject(KEY_INSTAGRAM_OBJECT,
            SaverInstagramSession.fromInstagrammApi(instagramApi))
    }

    fun getInstagramApi(): InstagramApi {
        val instagramApi: InstagramApi = storage.getObject<SaverInstagramSession>(
            KEY_INSTAGRAM_OBJECT, SaverInstagramSession::class.java)?.toInstagrammApi()
            ?: InstagramApi()
        instagramApi.setup()
        return instagramApi
    }

    fun clean() {
        storage.remove(KEY_INSTAGRAM_OBJECT)
    }
}
