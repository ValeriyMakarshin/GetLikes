package com.getlikes.util

import java.security.NoSuchAlgorithmException


class CipherUtil {
    companion object {
        const val MD5 = "MD5"


        fun md5Hex(s: String): String {
            try {
                val digest = java.security.MessageDigest
                    .getInstance(MD5)
                digest.update(s.toByteArray())
                val messageDigest = digest.digest()

                val hexString = StringBuilder()
                for (aMessageDigest in messageDigest) {
                    var h = Integer.toHexString(0xFF and aMessageDigest.toInt())
                    while (h.length < 2)
                        h = "0$h"
                    hexString.append(h)
                }
                return hexString.toString()

            } catch (e: NoSuchAlgorithmException) {
                e.printStackTrace()
            }

            return Strings.EMPTY
        }

    }

}