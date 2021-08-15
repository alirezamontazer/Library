package com.alimonapps.onlinelibrary.di.hiltmodules

import android.content.Context
import android.content.SharedPreferences
import com.alimonapps.onlinelibrary.PREF_NAME
import com.alimonapps.onlinelibrary.local.SharedPrefs
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object StorageModule {

    @Singleton
    @Provides
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    }

    @Singleton
    @Provides
    fun provideSharedPrefs(sharedPreferences: SharedPreferences, moshi: Moshi): SharedPrefs {
        return SharedPrefs(sharedPreferences, moshi)
    }

}