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

        val json = JsonUtils.bodyToString(request.body())
        val map = Gson().fromJson<TreeMap<String, String>>(json, TreeMap::class.java)

        val key = CipherUtil.md5Hex(
            map.values
                .joinToString(Strings.EMPTY)
                .plus(SALT))

        map[NAME_SIGNATURE] = key

        val newBody = RequestBody.create(JSON, Gson().toJson(map))

        val newRequest = Request.Builder()
            .url(request.url())
            .post(newBody)
            .build()

        return chain.proceed(newRequest)
    }

}