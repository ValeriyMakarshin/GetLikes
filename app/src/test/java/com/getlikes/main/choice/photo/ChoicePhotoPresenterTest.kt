package com.getlikes.main.choice.photo

import com.getlikes.util.RxHook
import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import dev.niekirk.com.instagram4android.requests.payload.InstagramFeedItem
import dev.niekirk.com.instagram4android.requests.payload.InstagramFeedResult
import io.reactivex.Observable
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ChoicePhotoPresenterTest {
    @Rule @JvmField val schedulers = RxHook()

    @Test fun loadDataTest() {
        val expectedInstagramFeedItems = ArrayList<InstagramFeedItem>()
        val mockInstagramFeedResult: InstagramFeedResult = mock {
            on { items }.doReturn(expectedInstagramFeedItems)
        }
        val mockChoicePhotoView: ChoicePhotoContract.View = mock()
        val mockChoicePhotoInteractor: ChoicePhotoInteractor = mock {
            on { getPhoto() }.thenReturn(Observable.just(mockInstagramFeedResult))
        }
        val choicePhotoPresenter = ChoicePhotoPresenter(mockChoicePhotoInteractor)
        choicePhotoPresenter.view = mockChoicePhotoView

        choicePhotoPresenter.loadData()

        verify(mockChoicePhotoView).showList(expectedInstagramFeedItems)
    }


}