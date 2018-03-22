package com.getlikes.util.storage

import java.lang.reflect.Type

interface Storage {
    companion object {
        const val KEY_FIRST_RUN = "key_first_run"
    }

    fun <T> getObject(key: String, clazz: Type): T?

    fun putObject(key: String, any: Any)

    fun putString(key: String, str: String)

    fun getString(key: String): String?

    fun putBoolean(key: String, value: Boolean)

    fun getBoolean(key: String, defValue: Boolean): Boolean

    fun remove(key: String)

    fun checkContains(key: String): Boolean
}
