package com.alimonapps.onlinelibrary.di

import android.content.Context
import android.content.SharedPreferences
import com.alimonapps.onlinelibrary.PREF_NAME
import com.alimonapps.onlinelibrary.local.SharedPrefs
import com.squareup.moshi.Moshi

fun provideSharedPreferences(context: Context): SharedPreferences? {
    return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
}

fun provideSharedPrefs(sharedPreferences: SharedPreferences, moshi: Moshi): SharedPrefs {
    return SharedPrefs(sharedPreferences, moshi)
}