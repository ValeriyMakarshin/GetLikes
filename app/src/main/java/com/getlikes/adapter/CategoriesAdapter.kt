package com.getlikes.adapter

import com.getlikes.adapter.holder.CategoriesHolder
import com.getlikes.core.BaseRAdapter
import com.getlikes.core.OnClickListener
import com.getlikes.model.Category

class CategoriesAdapter(array: Array<Category>, onClickListener: OnClickListener<Category>) :
    BaseRAdapter<Category, CategoriesHolder>(array, CategoriesHolder.creator(), onClickListener)
