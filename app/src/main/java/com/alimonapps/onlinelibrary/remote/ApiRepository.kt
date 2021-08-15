package com.alimonapps.onlinelibrary.remote

import com.alimonapps.onlinelibrary.datamodel.allbooks.ResponseAllBooks
import com.alimonapps.onlinelibrary.datamodel.bestpodcast.ResponseBestPodcast
import com.alimonapps.onlinelibrary.datamodel.searchaudio.ResponseAudioSearch
import com.alimonapps.onlinelibrary.remote.errorhandling.Resource
import com.alimonapps.onlinelibrary.remote.errorhandling.ResponseHandler


class ApiRepository
constructor(
    private val apiService: ApiService,
    private val responseHandler: ResponseHandler
) {


    suspend fun getBookList(keyWord: String): Resource<ResponseAllBooks> {
        return try {
            val response = apiService.getBookList(keyWord)
            responseHandler.handleSuccess(response)
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }

    suspend fun getBestPodcast(
        apiKey: String = "f48c6b05d9ad44419ed5da43dd1136ed",
        region: String = "us",
        value: Int = 0
    ): Resource<ResponseBestPodcast> {
        return try {
            val response = apiService.getBestPodcast(apiKey, region, value)
            responseHandler.handleSuccess(response)
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }

    suspend fun getAudioSearch(
        apiKey: String = "f48c6b05d9ad44419ed5da43dd1136ed",
        q: String,
        type: String,
        language: String,
    ): Resource<ResponseAudioSearch> {
        return try {
            val response = apiService.getPodcastSearch(apiKey, q, type, language)
            responseHandler.handleSuccess(response)
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }

    }

}
