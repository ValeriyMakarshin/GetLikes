package com.getlikes.core

import android.os.Bundle
import android.support.annotation.CallSuper
import android.util.Log
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

open class BasePresenter<V : BaseContract.View> : BaseContract.Presenter<V> {
    var view: V? = null
    var bundle: Bundle? = null
    var disposable: Disposable? = null

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
            disposable = null
        }
    }

    fun <T> baseObservable(observable: Observable<T>,
                           functionSuccess: (T) -> Unit = {},
                           functionError: (Throwable) -> Unit = {
                               view?.showError(it)
                           }) {
        if (disposable != null) return
        disposable = observable
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                view?.showProgress()
            }
            .doOnError {
                Log.e("132", "123")
            }
            .doOnTerminate {
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
