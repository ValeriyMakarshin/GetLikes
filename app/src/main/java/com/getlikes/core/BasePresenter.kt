package com.getlikes.core

import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.annotation.VisibleForTesting
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

open class BasePresenter<V : BaseContract.View> : BaseContract.Presenter<V> {
    @VisibleForTesting var view: V? = null
    @VisibleForTesting var bundle: Bundle? = null
    @VisibleForTesting var disposable: Disposable? = null

    @CallSuper override fun attach(view: V, bundle: Bundle?) {
        this.view = view
        bundle?.let { parseArguments(it) }

        loadData()
    }

    @CallSuper
    override fun parseArguments(extras: Bundle) {
        this.bundle = extras
    }

    override fun loadData() {

    }

    @CallSuper
    override fun detach() {
        unsubscribeSubscription()
    }

    override fun unsubscribeSubscription() {
        if (disposable?.isDisposed == false) {
            disposable?.dispose()
        }
        disposable = null
    }

    fun <T> baseObservable(single: Single<T>,
                           functionSuccess: (T) -> Unit = {},
                           functionError: (Throwable) -> Unit = {
                               view?.showError(it)
                           }) {
        if (disposable != null) return
        disposable = single
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                view?.showProgress()
            }
            .doAfterTerminate {
                unsubscribeSubscription()
                view?.hideProgress()
            }
            .subscribe(
                {
                    it?.let { functionSuccess(it) }
                },
                {
                    functionError(it)
                })
    }


}
