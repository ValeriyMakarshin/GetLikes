package com.getlikes.core

import android.os.Bundle
import com.getlikes.util.RxHook
import com.nhaarman.mockito_kotlin.*
import io.reactivex.disposables.Disposable
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

    @Test fun attachTestWithoutBundle() {
        spyBasePresenter.attach(mockBaseView)

        Assert.assertNotNull(spyBasePresenter.view)
        verify(spyBasePresenter).loadData()
        verify(spyBasePresenter, never()).parseArguments(any())
    }

    @Test fun attachTestWithBundle() {
        val mockBundle: Bundle = mock()

        spyBasePresenter.attach(mockBaseView, mockBundle)

        Assert.assertNotNull(spyBasePresenter.view)
        verify(spyBasePresenter).loadData()
        verify(spyBasePresenter).parseArguments(mockBundle)
    }

    @Test fun parseArgumentsTest() {
        val mockBundle: Bundle = mock()

        spyBasePresenter.parseArguments(mockBundle)

        Assert.assertEquals(mockBundle, spyBasePresenter.bundle)
    }

    @Test fun detachTest() {
        spyBasePresenter.detach()

        verify(spyBasePresenter).unsubscribeSubscription()
    }

    @Test fun unsubscribeSubscriptionTestFalse() {
        val mockDisposable: Disposable = mock { on { isDisposed }.doReturn(false) }
        spyBasePresenter.disposable = mockDisposable

        spyBasePresenter.unsubscribeSubscription()

        verify(mockDisposable).dispose()
        Assert.assertNull(spyBasePresenter.disposable)
    }

    @Test fun unsubscribeSubscriptionTestTrue() {
        val mockDisposable: Disposable = mock { on { isDisposed }.doReturn(true) }
        spyBasePresenter.disposable = mockDisposable

        spyBasePresenter.unsubscribeSubscription()

        verify(mockDisposable, never()).dispose()
        Assert.assertNotNull(spyBasePresenter.disposable)
    }

}