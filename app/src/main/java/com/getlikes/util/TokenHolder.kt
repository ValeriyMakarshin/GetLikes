package com.getlikes.util

import com.getlikes.util.storage.Storage

class TokenHolder(private val storage: Storage) {
    companion object {
        val KEY_LOGIN = "key_login"
        val KEY_PASSWORD = "key_password"

        val KEY_LOGGED_USER = "key_logged_user"

        val KEY_USER_ID = "key_user_id"

        private val KEY_TOKEN = "key_token"
        private val KEY_EMAIL = "key_email"
        private val KEY_ID = "key_id"
    }

    val email: String?
        get() = storage.getString(KEY_EMAIL)

    val id: String?
        get() = storage.getString(KEY_ID)

    fun saveSession(token: String, email: String, id: String, notification: String) {
        clean()

        storage.putString(KEY_TOKEN, token)
        storage.putString(KEY_EMAIL, email)
        storage.putString(KEY_ID, id)
    }

    fun clean() {
        storage.remove(KEY_TOKEN)
        storage.remove(KEY_EMAIL)
        storage.remove(KEY_ID)
    }
}
