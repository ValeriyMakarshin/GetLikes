package com.getlikes.util

import org.jetbrains.annotations.Contract

class Strings {
    companion object {
        val EMPTY = ""
        val EMPTY_TEXT = "-"

        private val EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+" +
            "(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"

        private val PHONE_REGEX = "^((\\+7)|(8))+[0-9]{10}$"

        @Contract("null -> true")
        fun isEmpty(str: String?): Boolean {
            return str == null || str.isEmpty()
        }

        fun isCorrectEmail(email: String): Boolean {
            return email.matches(EMAIL_REGEX.toRegex())
        }

        fun isCorrectPhone(phone: String): Boolean {
            return phone.matches(PHONE_REGEX.toRegex())
        }

        fun isCorrectPassword(password: String): Boolean {
            return password.length >= 8
        }

    }

}
