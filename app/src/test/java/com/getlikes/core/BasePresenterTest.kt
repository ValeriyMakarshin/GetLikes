package com.getlikes.core

import com.getlikes.util.RxHook
import com.nhaarman.mockito_kotlin.verify
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Spy
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class BasePresenterTest {
    @Rule @JvmField val schedulers = RxHook()

    @Mock private lateinit var mockBaseView: BaseContract.View

    @Spy private lateinit var spyBasePresenter: BasePresenter<BaseContract.View>

    @Test fun attachTest() {
        spyBasePresenter.attach(mockBaseView)

        Assert.assertNotNull(mockBaseView)
        verify(spyBasePresenter).loadData()
    }
}