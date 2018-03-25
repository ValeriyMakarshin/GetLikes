package com.getlikes.network

import com.getlikes.util.CipherUtil
import com.getlikes.util.JsonUtils
import com.getlikes.util.Strings
import com.google.gson.Gson
import okhttp3.*
import java.util.*

class SignatureInterceptor : Interceptor {
    companion object {
        const val SALT = "7dV~US"
        const val NAME_SIGNATURE = "signature"

        val JSON = MediaType.parse("application/json; charset=utf-8")
    }

    override fun intercept(chain: Interceptor.Chain?): Response {
        if (chain == null) {
            throw NullPointerException("Interceptor.Chain is null")
        }

        val request: Request = chain.request()

        val map = Gson().fromJson<TreeMap<String, String>>(
            JsonUtils.bodyToString(request.body()),
            TreeMap::class.java)

        map[NAME_SIGNATURE] =
            CipherUtil.md5Hex(
                map.values
                    .joinToString(Strings.EMPTY)
                    .plus(SALT))

        val newRequest = Request.Builder()
            .url(request.url())
            .post(
                RequestBody.create(JSON, Gson().toJson(map)))
            .build()

        return chain.proceed(newRequest)
    }

}
