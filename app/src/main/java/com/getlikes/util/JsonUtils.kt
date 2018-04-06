package com.getlikes.util

import android.content.res.AssetManager
import com.google.gson.Gson
import okhttp3.RequestBody
import okio.Buffer
import java.io.IOException
import java.lang.reflect.Type


class JsonUtils {
    companion object {
        private const val UTF_8_FORMAT = "UTF-8"

        fun bodyToString(request: RequestBody?): String {
            val buffer = Buffer()
            if (request != null) {
                request.writeTo(buffer)
            } else {
                return Strings.EMPTY
            }
            return buffer.readUtf8()
        }

        fun loadJSONFromInputStream(assetManager: AssetManager, filename: String): String? =
            try {
                val inputStream = assetManager.open(filename)
                val size = inputStream.available()
                val buffer = ByteArray(size)
                inputStream.read(buffer)
                inputStream.close()
                String(buffer, charset(UTF_8_FORMAT))
            } catch (ioException: IOException) {
                ioException.printStackTrace()
                null
            }

        fun <T> parseToObject(gson: Gson, json: String, clazz: Type): T? =
            try {
                gson.fromJson(json, clazz) as T
            } catch (e: IOException) {
                e.printStackTrace()
                null
            }
    }
}
