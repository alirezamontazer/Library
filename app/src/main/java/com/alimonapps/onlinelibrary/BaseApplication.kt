package com.alimonapps.onlinelibrary

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }


//        // start Koin!
//        startKoin {
//            androidLogger(Level.ERROR)
//            androidContext(this@BaseApplication)
//            modules(listOf(networkModule, viewModelModule, storeModules))
//
//        }

    }
}