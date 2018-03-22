package com.getlikes.splash

import com.getlikes.util.storage.Storage

class SplashInteractorImpl(val storage: Storage)
    : SplashInteractor {

    override fun isFirstRun(): Boolean {
        return storage.getBoolean(Storage.KEY_FIRST_RUN, false)
    }

}
