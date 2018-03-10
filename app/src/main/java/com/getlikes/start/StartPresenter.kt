package com.getlikes.start

import android.util.Log
import com.getlikes.core.BasePresenter

class StartPresenter : BasePresenter<StartContract.View>(), StartContract.Presenter {
    override fun goToLogin() {
        Log.i("132", "1324")
    }
}
