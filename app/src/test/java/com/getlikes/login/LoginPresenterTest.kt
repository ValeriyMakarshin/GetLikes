package com.getlikes.login

import com.getlikes.model.Answer
import com.getlikes.model.Session
import com.getlikes.util.RxHook
import com.getlikes.util.Strings
import com.getlikes.util.storage.Storage
import com.nhaarman.mockito_kotlin.*
import io.reactivex.Single
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

    @Test fun loginInstagramTest() {
        val expectedLogin = "expectedLogin"
        val expectedPassword = "expectedPassword"
        val expectedAnswerSession: Answer<Session> = mock()
        doReturn(Single.just(expectedAnswerSession))
            .`when`(mockLoginInteractor).loginInstagram(any(), any())

        spyLoginPresenter.loginInstagram(expectedLogin, expectedPassword)

        verify(mockLoginView).goToMain()
    }

    @Test fun loginInstagramTestError() {
        val expectedThrowable = Throwable()
        doReturn(Single.error<Answer<Session>>(expectedThrowable))
            .`when`(mockLoginInteractor).loginInstagram(any(), any())

        spyLoginPresenter.loginInstagram(Strings.EMPTY, Strings.EMPTY)

        verify(mockLoginView).showError(expectedThrowable)
    }

}
