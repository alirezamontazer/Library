package com.alimonapps.onlinelibrary.ui.splash

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alimonapps.onlinelibrary.datamodel.allbooks.ResponseAllBooks
import com.alimonapps.onlinelibrary.datamodel.bestpodcast.ResponseBestPodcast
import com.alimonapps.onlinelibrary.di.hiltmodules.Audio
import com.alimonapps.onlinelibrary.di.hiltmodules.Book
import com.alimonapps.onlinelibrary.local.SharedPrefs
import com.alimonapps.onlinelibrary.remote.ApiRepository
import com.alimonapps.onlinelibrary.remote.errorhandling.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
class SplashViewModel
@ViewModelInject
constructor(
    @Audio private val audioApiRepository: ApiRepository,
    @Book private val bookApiRepository: ApiRepository,
    private val sharedPrefs: SharedPrefs
) : ViewModel() {

    private val TAG = "SplashViewModel"

    val minimumSplashWaitingPassed = MutableLiveData<Boolean>()
    private val minimumSplashWait = 5000L
    val responseAllBooks = MutableLiveData<Resource<ResponseAllBooks>>()
    val responseBestPodcast = MutableLiveData<Resource<ResponseBestPodcast>>()
    private var randomNumber = 0


    init {
        splashWait()
        getBestPodcast()
        getAllBooks()
    }


    private fun setBookSubject(): String {
        val random = java.util.Random()
        randomNumber = random.nextInt(9)
        return when (randomNumber) {
            0 -> "science"
            1 -> "journal"
            2 -> "biography"
            3 -> "funny"
            4 -> "kids"
            5 -> "romance"
            6 -> "sport"
            7 -> "game"
            8 -> "computer"
            9 -> "history"
            else -> ""
        }
    }


    private fun splashWait() {
        viewModelScope.launch {
            delay(minimumSplashWait)
            minimumSplashWaitingPassed.value = true
        }
    }

    private fun getAllBooks() {
        val bookSubject = setBookSubject()
        viewModelScope.launch(Dispatchers.IO) {
            val response = bookApiRepository.getBookList(bookSubject)
            responseAllBooks.postValue(response)
        }
    }

    private fun getBestPodcast() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = audioApiRepository.getBestPodcast()
            responseBestPodcast.postValue(response)
        }
    }

    fun saveBooksData(data: ResponseAllBooks) {
        sharedPrefs.saveBooksData(data)
    }

    fun saveAudioData(data: ResponseBestPodcast) {
        sharedPrefs.saveAudioData(data)
    }

}