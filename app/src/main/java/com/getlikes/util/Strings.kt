package com.getlikes.util

import org.jetbrains.annotations.Contract

class Strings {
    companion object {
        val EMPTY = ""
        val EMPTY_TEXT = "-"
        val MOD_VALUE = 0xFF

        private val EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+" +
            "(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"

        private val PHONE_REGEX = "^((\\+7)|(8))+[0-9]{10}$"

        @Contract("null -> true")
        fun isEmpty(str: String?): Boolean {
            return str == null || str.isEmpty()
        }
    }

}
