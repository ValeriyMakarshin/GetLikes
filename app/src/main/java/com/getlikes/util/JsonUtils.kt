package com.getlikes.util

import okhttp3.RequestBody
import okio.Buffer


class JsonUtils {
    companion object {
        fun bodyToString(request: RequestBody?): String {
            val buffer = Buffer()
            if (request != null) {
                request.writeTo(buffer)
            } else {
                return Strings.EMPTY
            }
            return buffer.readUtf8()
        }
    }

}