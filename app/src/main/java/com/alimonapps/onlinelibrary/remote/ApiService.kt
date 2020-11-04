package com.alimonapps.onlinelibrary.remote

import com.alimonapps.onlinelibrary.datamodel.allbooks.ResponseAllBooks
import com.alimonapps.onlinelibrary.datamodel.bestpodcast.ResponseBestPodcast
import com.alimonapps.onlinelibrary.datamodel.searchaudio.ResponseAudioSearch
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query


interface ApiService {

    @GET("/books/v1/volumes")
    suspend fun getBookList(@Query("q") keyWord: String): ResponseAllBooks

    @GET("/api/v2/best_podcasts")
    suspend fun getBestPodcast(
        @Header("X-ListenAPI-Key") apiKey: String,
        @Query("region") region: String,
        @Query("safe_mode") value: Int
    ): ResponseBestPodcast

    @GET("/api/v2/search")
    suspend fun getPodcastSearch(
        @Header("X-ListenAPI-Key") apiKey: String,
        @Query("q") q: String,
        @Query("type") type: String,
        @Query("language") language: String
    ): ResponseAudioSearch

}
