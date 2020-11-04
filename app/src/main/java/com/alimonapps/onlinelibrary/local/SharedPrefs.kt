package com.alimonapps.onlinelibrary.local

import android.content.SharedPreferences
import com.alimonapps.onlinelibrary.datamodel.allbooks.ResponseAllBooks
import com.alimonapps.onlinelibrary.datamodel.bestpodcast.ResponseBestPodcast
import com.squareup.moshi.Moshi

class SharedPrefs(
    private val mPreferences: SharedPreferences,
    private val moshi: Moshi
) {

    companion object {
        private const val BOOKS_DATA = "books_data"
        private const val AUDIO_DATA = "audio_data"
        private const val BOOK_DATA_SEARCH = "book_data_search"
        private const val AUDIO_DATA_SEARCH = "audio_data_search"
    }

    fun saveBookSearch(responseAllBooks: ResponseAllBooks) {
        val json = moshi.adapter(ResponseAllBooks::class.java).toJson(responseAllBooks)
        putString(BOOK_DATA_SEARCH, json)
    }

    fun loadBookSearch(): ResponseAllBooks? {
        if (getString(BOOK_DATA_SEARCH).isNotEmpty()) {
            return moshi.adapter(ResponseAllBooks::class.java).fromJson(getString(BOOK_DATA_SEARCH))
        }
        return null
    }

    fun saveBooksData(responseAllBooks: ResponseAllBooks) {
        val json = moshi.adapter(ResponseAllBooks::class.java).toJson(responseAllBooks)
        putString(BOOKS_DATA, json)
    }

    fun saveAudioData(responseBestPodcast: ResponseBestPodcast) {
        val json = moshi.adapter(ResponseBestPodcast::class.java).toJson(responseBestPodcast)
        putString(AUDIO_DATA, json)
    }

    fun loadBooksData(): ResponseAllBooks? {
        if (getString(BOOKS_DATA).isNotEmpty()) {
            return moshi.adapter(ResponseAllBooks::class.java).fromJson(getString(BOOKS_DATA))
        }
        return null
    }

    fun loadAudioData(): ResponseBestPodcast? {
        if (getString(AUDIO_DATA).isNotEmpty()) {
            return moshi.adapter(ResponseBestPodcast::class.java).fromJson(getString(AUDIO_DATA))
        }
        return null
    }

    private fun putString(key: String, value: String) {
        mPreferences.edit().putString(key, value).apply()
    }

    private fun getString(key: String, default: String = ""): String {
        return mPreferences.getString(key, null) ?: default
    }

}