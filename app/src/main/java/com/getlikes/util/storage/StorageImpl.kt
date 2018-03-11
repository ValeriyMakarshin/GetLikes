package com.getlikes.util.storage

import android.content.SharedPreferences
import com.getlikes.model.User
import com.getlikes.util.Strings
import com.google.gson.Gson
import java.io.IOException
import java.lang.reflect.Type

class StorageImpl(private val sp: SharedPreferences, private val gson: Gson) : Storage {
    override fun <T> get(key: String, clazz: Type): T? {
        val json = sp.getString(key, Strings.EMPTY)
        if (Strings.isEmpty(json))
            return null
        else {
            try {
                return gson.fromJson(json, Type::class.java) as T
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
        return null
    }

    override fun putUser(key: String, user: User) {
        sp.edit().putString(key, gson.toJson(user)).apply()
    }

    override fun putString(key: String, str: String) {
        sp.edit().putString(key, str).apply()
    }

    override fun getString(key: String): String? {
        return sp.getString(key, null)
    }

    override fun remove(key: String) {
        sp.edit().remove(key).apply()
    }

}