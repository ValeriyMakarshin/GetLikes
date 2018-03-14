package com.getlikes.model

enum class Status(val value: String) {
    OK("ok"),
    FAIL("fail");

    companion object {
        fun parseStatus(value: String): Status? {
            Status.values().forEach {
                if (it.value == value)
                    return it
            }
            return null
        }
    }
}


