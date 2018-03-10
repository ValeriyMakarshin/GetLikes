package com.getlikes.core

import com.arellomobile.mvp.MvpPresenter

open class BasePresenter<V : BaseContract.View> : MvpPresenter<V>(), BaseContract.Presenter<V> {

}
