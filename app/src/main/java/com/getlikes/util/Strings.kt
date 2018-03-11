package com.getlikes.util

import org.jetbrains.annotations.Contract
import java.security.NoSuchAlgorithmException
import java.util.*


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

        fun generateToken(): String {
            val now = Date()
            val random = Random()
            return md5(now.toString() + random.nextInt())
        }

        private fun md5(s: String): String {
            try {
                val digest = java.security.MessageDigest.getInstance("MD5")
                digest.update(s.toByteArray())
                val messageDigest = digest.digest()

                val hexString = StringBuffer()
                for (i in messageDigest.indices)
                    hexString.append(Integer.toHexString(0xFF and messageDigest[i].toInt()))
                return hexString.toString()

            } catch (e: NoSuchAlgorithmException) {
                e.printStackTrace()
            }

            return ""
        }

    }

}
