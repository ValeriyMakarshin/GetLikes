package com.getlikes.network

import com.getlikes.util.CipherUtil
import okhttp3.FormBody
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class SignatureInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain?): Response {
        if (chain == null) {
            throw NullPointerException("Interceptor.Chain is null")
        }

        val request: Request = chain.request()

        val formBody = request.body() as FormBody

        val pairs = ArrayList<Pair<String, String>>()
            .apply {
                for (i in 0 until formBody.size()) {
                    this.add(Pair(formBody.encodedName(i), formBody.encodedValue(i)))
                }
            }

        val signature = CipherUtil.md5Hex(
            pairs
                .apply {
                    sortWith(Comparator { o1, o2 ->
                        o2?.first?.let { o1?.first?.compareTo(it) }
                            ?: throw NullPointerException("Null formBody name")
                    })
                }
                .joinToString(separator = "", transform = { pair -> pair.second })
                .plus(NetworkBase.SALT)
        )


        val newBody = FormBody.Builder()
            .apply {
                pairs.forEach { add(it.first, it.second) }
                add(NetworkBase.NAME_SIGNATURE, signature)
            }
            .build()

        val newRequest = Request.Builder()
            .url(request.url())
            .post(newBody)
            .build()

        return chain.proceed(newRequest)
    }

}