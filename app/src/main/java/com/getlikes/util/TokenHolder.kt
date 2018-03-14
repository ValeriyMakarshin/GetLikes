package com.getlikes.util

import com.getlikes.util.storage.Storage

class TokenHolder(private val storage: Storage) {
    companion object {
        val KEY_LOGIN = "key_login"
        val KEY_PASSWORD = "key_password"
        val KEY_USERNAME = "key_username"

        val KEY_COOKIE = "key_cookie"
        val KEY_USER_ID = "key_user_id"
        val KEY_SESSION_ID = "key_session_id"

        private val KEY_TOKEN = "key_token"
        private val KEY_EMAIL = "key_email"
        private val KEY_ID = "key_id"
    }

    val token: String
        get() {
            var token = storage.getString(KEY_TOKEN)
            if (Strings.isEmpty(token)) {
                token = Strings.generateToken()
                storage.putString(KEY_TOKEN, token)
            }
            return token!!
        }

    val sessionId: String?
        get() = storage.getString(KEY_SESSION_ID)

    val cookie: String
        get() {
            var s = "csrftoken=$token"
            sessionId?.let { s += "; sessionid=$it" }
            return s
        }

    val email: String?
        get() = storage.getString(KEY_EMAIL)

    val id: String?
        get() = storage.getString(KEY_ID)

    val isUserAuthorized: Boolean
        get() = !Strings.isEmpty(token)

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
