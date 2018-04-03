package com.getlikes.login

import com.getlikes.model.InstagramStatus
import com.getlikes.util.RxHook
import com.getlikes.util.Strings
import com.getlikes.util.TokenHolder
import com.getlikes.util.storage.Storage
import com.nhaarman.mockito_kotlin.*
import dev.niekirk.com.instagram4android.requests.payload.InstagramLoggedUser
import dev.niekirk.com.instagram4android.requests.payload.InstagramLoginResult
import io.reactivex.Observable
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class LoginPresenterTest {
    @Rule @JvmField val schedulers = RxHook()

    @Mock private lateinit var mockLoginInteractor: LoginInteractor
    @Mock private lateinit var mockStorage: Storage
    @Mock private lateinit var mockLoginView: LoginContract.View

    lateinit var spyLoginPresenter: LoginPresenter

    @Before fun setUp() {
        spyLoginPresenter = spy(LoginPresenter(mockLoginInteractor, mockStorage))
        spyLoginPresenter.view = mockLoginView
    }

    @Test fun loginInstagramTestStatusOk() {
        val expectedLogin = "expectedLogin"
        val expectedPassword = "expectedPassword"
        val expectedUsername = "expectedUsername"
        val expectedPk = 123456789L
        val expectedInstagramLoggedUser = InstagramLoggedUser().apply {
            username = expectedUsername
            pk = expectedPk
        }
        val mockInstagramLoginResult: InstagramLoginResult = mock {
            on { status }.doReturn(InstagramStatus.OK.value)
            on { logged_in_user }.doReturn(expectedInstagramLoggedUser)
        }
        doReturn(Observable.just(mockInstagramLoginResult))
            .`when`(mockLoginInteractor).loginInstagram(any(), any())
        doNothing()
            .`when`(spyLoginPresenter).loginApi(any(), any())

        spyLoginPresenter.loginInstagram(expectedLogin, expectedPassword)

        verify(mockLoginInteractor).loginInstagram(expectedLogin, expectedPassword)
        verify(mockStorage).putString(TokenHolder.KEY_LOGIN, expectedLogin)
        verify(mockStorage).putString(TokenHolder.KEY_PASSWORD, expectedPassword)
        verify(mockStorage).putObject(TokenHolder.KEY_LOGGED_USER, expectedInstagramLoggedUser)
        verify(spyLoginPresenter).loginApi(expectedUsername, expectedPk)
        verify(mockLoginView, never()).showError(any())
    }

    @Test fun loginInstagramTestStatusFail() {
        val mockInstagramLoginResult: InstagramLoginResult = mock {
            on { status }.doReturn(InstagramStatus.FAIL.value)
        }
        doReturn(Observable.just(mockInstagramLoginResult))
            .`when`(mockLoginInteractor).loginInstagram(any(), any())

        spyLoginPresenter.loginInstagram(Strings.EMPTY, Strings.EMPTY)

        verify(mockLoginView).showError(any())
        verify(spyLoginPresenter, never()).loginApi(any(), any())
        verifyZeroInteractions(mockStorage)
    }

}