package com.getlikes.main.tags

import android.content.Context
import com.getlikes.model.TagGroup
import com.getlikes.util.JsonUtils
import com.google.gson.Gson
import com.google.gson.JsonParseException
import io.reactivex.Single

class CategoriesInteractorImpl(val context: Context, val gson: Gson) : CategoriesInteractor {
    companion object {
        const val filename = "tags.json"
    }

    override fun getTagGroup(): Single<TagGroup> {
        return Single.create<TagGroup> { single ->
            JsonUtils.loadJSONFromAsset(context.assets, filename)
                ?.let {
                    JsonUtils.parseToObject<TagGroup>(gson, it, TagGroup::class.java)
                        ?.let {
                            single.onSuccess(it)
                        }
                        ?: single.onError(JsonParseException("Bad tagGroup json"))
                }
                ?: single.onError(AssertionError("Not found file with tags"))
        }
    }
}
