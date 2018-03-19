package com.getlikes.util.storage

import java.lang.reflect.Type

interface Storage {

    fun <T> getObject(key: String, clazz: Type): T?

    fun putObject(key: String, any: Any)

    fun putString(key: String, str: String)

    fun getString(key: String): String?

    fun remove(key: String)

}
