package com.getlikes.util

import com.getlikes.util.storage.Storage

class TokenHolder(private val storage: Storage) {
    companion object {
        private val KEY_TOKEN = "token"
        private val KEY_EMAIL = "email"
        private val KEY_ID = "id"
        private val KEY_NOTIFICATION_TOKEN = "notification_token"
    }

    val token: String?
        get() = storage.getString(KEY_TOKEN)

    val email: String?
        get() = storage.getString(KEY_EMAIL)

    val id: String?
        get() = storage.getString(KEY_ID)

    val notificationToken: String?
        get() = storage.getString(KEY_NOTIFICATION_TOKEN)

    val isUserAuthorized: Boolean
        get() = !Strings.isEmpty(token)

    fun saveSession(token: String, email: String, id: String, notification: String) {
        clean()

        storage.putString(KEY_TOKEN, token)
        storage.putString(KEY_EMAIL, email)
        storage.putString(KEY_ID, id)
        storage.putString(KEY_NOTIFICATION_TOKEN, notification)
    }

    fun clean() {
        storage.remove(KEY_TOKEN)
        storage.remove(KEY_EMAIL)
        storage.remove(KEY_ID)
        storage.remove(KEY_NOTIFICATION_TOKEN)
    }
}
