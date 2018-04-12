package com.getlikes.main.tags

import com.getlikes.model.TagGroup
import io.reactivex.Single

interface CategoriesInteractor {
    fun getTagGroup(): Single<TagGroup>
}
