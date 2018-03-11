package com.getlikes.util.storage

import com.getlikes.model.User
import java.lang.reflect.Type

interface Storage {

    operator fun <T> get(key: String, clazz: Type): T?

    fun putUser(key: String, user: User)

    fun putString(key: String, str: String)

    fun getString(key: String): String?

    fun remove(key: String)

}
