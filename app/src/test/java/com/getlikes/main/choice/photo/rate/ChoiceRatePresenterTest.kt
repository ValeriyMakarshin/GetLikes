package com.getlikes.main.choice.photo.rate

import android.os.Bundle
import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import dev.niekirk.com.instagram4android.requests.payload.InstagramFeedItem
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ChoiceRatePresenterTest {
    private val choiceRatePresenter = ChoiceRatePresenter()

    @Test fun parseArgumentsTest() {
        val expectedInstagramFeedItem = InstagramFeedItem()
        val mockBundle: Bundle = mock {
            on { getSerializable(ChoiceRateFragment.EXTRA_FEED_ITEM) }
                .doReturn(expectedInstagramFeedItem)
        }

        choiceRatePresenter.parseArguments(mockBundle)

        Assert.assertEquals(choiceRatePresenter.feedItem, expectedInstagramFeedItem)
    }

    @Test fun attachTest() {
        val expectedInstagramFeedItem = InstagramFeedItem()
        val mockChoiceRateView: ChoiceRateContract.View = mock()
        choiceRatePresenter.feedItem = expectedInstagramFeedItem

        choiceRatePresenter.attach(mockChoiceRateView)

        mockChoiceRateView.showList(Rates.values(), expectedInstagramFeedItem)
    }
}
