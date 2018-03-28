package com.getlikes.model

enum class InstagramStatus(val value: String) {
    OK("ok"),
    FAIL("fail");

    companion object {
        fun parseStatus(value: String): InstagramStatus? {
            InstagramStatus.values().forEach {
                if (it.value == value)
                    return it
            }
            return null
        }
    }
}


