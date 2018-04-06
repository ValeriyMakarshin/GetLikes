package com.getlikes.util.storage

import android.content.SharedPreferences
import com.getlikes.util.JsonUtils
import com.getlikes.util.Strings
import com.google.gson.Gson
import java.io.IOException
import java.lang.reflect.Type

class StorageImpl(private val sp: SharedPreferences, private val gson: Gson) : Storage {
    @Suppress("UNCHECKED_CAST")
    override fun <T> getObject(key: String, clazz: Type): T? {
        val json = sp.getString(key, Strings.EMPTY)
        if (!Strings.isEmpty(json)) {
            return JsonUtils.parseToObject(gson, json, clazz)
        }
        return null
    }

    override fun putObject(key: String, any: Any) {
        sp.edit().putString(key, gson.toJson(any)).apply()
    }

    override fun putString(key: String, str: String) {
        sp.edit().putString(key, str).apply()
    }

    override fun getString(key: String): String? {
        return sp.getString(key, null)
    }

    override fun putBoolean(key: String, value: Boolean) {
        sp.edit().putBoolean(key, value).apply()
    }

    override fun getBoolean(key: String, defValue: Boolean): Boolean {
        return sp.getBoolean(key, defValue)
    }

    override fun remove(key: String) {
        sp.edit().remove(key).apply()
    }

    override fun checkContains(key: String): Boolean {
        return sp.contains(key)
    }
}
