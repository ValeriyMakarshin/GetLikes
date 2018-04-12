package com.getlikes.main.categories

import com.getlikes.model.TagGroup
import io.reactivex.Single

interface CategoriesInteractor {
    fun getTagGroup(): Single<TagGroup>
}
