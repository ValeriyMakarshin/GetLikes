package com.getlikes.core

interface OnClickListener<in T> {
    fun onClick(item: T)
}
