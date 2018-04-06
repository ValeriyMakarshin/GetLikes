package com.getlikes.main.hashtags

import com.getlikes.model.TagGroup
import io.reactivex.Single

interface HashTagsInteractor {
    fun getTagGroup(): Single<TagGroup>
}
