package com.getlikes.core

import android.os.Bundle
import com.getlikes.util.RxHook
import com.nhaarman.mockito_kotlin.*
import io.reactivex.Observable
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

    @Test fun baseObservableTest() {
        val expectedAny = Any()
        val expectedObservable = Observable.just(expectedAny)
        val mockFunctionSuccess: (Any) -> Unit = mock()
        val mockFunctionError: (Throwable) -> Unit = mock()
        spyBasePresenter.view = mockBaseView

        spyBasePresenter.baseObservable(expectedObservable,
            mockFunctionSuccess, mockFunctionError)

        verify(mockBaseView).showProgress()
        verify(mockBaseView).hideProgress()
        verify(spyBasePresenter).unsubscribeSubscription()
        verify(mockFunctionSuccess).invoke(expectedAny)
        verify(mockFunctionError, never()).invoke(any())
    }

    @Test fun baseObservableTestThrowable() {
        val expectedThrowable = Throwable()
        val mockObservable = Observable.error<Any>(expectedThrowable)
        val mockFunctionSuccess: (Any) -> Unit = mock()
        val mockFunctionError: (Throwable) -> Unit = mock()
        spyBasePresenter.view = mockBaseView

        spyBasePresenter.baseObservable(mockObservable,
            mockFunctionSuccess, mockFunctionError)

        verify(mockBaseView).showProgress()
        verify(mockBaseView).hideProgress()
        verify(spyBasePresenter).unsubscribeSubscription()
        verify(mockFunctionSuccess, never()).invoke(any())
        verify(mockFunctionError).invoke(expectedThrowable)
    }

    @Test fun baseObservableTestBaseThrowable() {
        val expectedThrowable = Throwable()
        val mockObservable = Observable.error<Any>(expectedThrowable)
        val mockFunctionSuccess: (Any) -> Unit = mock()
        spyBasePresenter.view = mockBaseView

        spyBasePresenter.baseObservable(mockObservable,
            mockFunctionSuccess)

        verify(mockBaseView).showProgress()
        verify(mockBaseView).hideProgress()
        verify(spyBasePresenter).unsubscribeSubscription()
        verify(mockFunctionSuccess, never()).invoke(any())
        verify(mockBaseView).showError(expectedThrowable)
    }

    @Test fun baseObservableTestDisposable() {
        val mockDisposable: Disposable = mock()
        val mockObservable = Observable.empty<Any>()
        val mockFunctionSuccess: (Any) -> Unit = mock()
        spyBasePresenter.view = mockBaseView
        spyBasePresenter.disposable = mockDisposable

        spyBasePresenter.baseObservable(mockObservable, mockFunctionSuccess)

        verify(mockFunctionSuccess, never()).invoke(any())
        verifyZeroInteractions(mockBaseView)
    }

}
