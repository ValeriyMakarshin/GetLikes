package com.getlikes.adapter

import com.getlikes.adapter.holder.CategoriesHolder
import com.getlikes.core.BaseRAdapter
import com.getlikes.model.Category

class CategoriesAdapter(array: Array<Category>) :
    BaseRAdapter<Category, CategoriesHolder>(array, CategoriesHolder.creator()) {

}
