package com.alimonapps.onlinelibrary

import android.app.Application
import com.alimonapps.onlinelibrary.di.networkModule
import com.alimonapps.onlinelibrary.di.storeModules
import com.alimonapps.onlinelibrary.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree());
        }


        // start Koin!
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@BaseApplication)
            modules(listOf(networkModule, viewModelModule, storeModules))

        }
    }
}