package com.alimonapps.onlinelibrary.ui.discover

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.alimonapps.onlinelibrary.baseclasses.BaseViewModel
import com.alimonapps.onlinelibrary.datamodel.allbooks.ResponseAllBooks
import com.alimonapps.onlinelibrary.di.hiltmodules.Book
import com.alimonapps.onlinelibrary.local.SharedPrefs
import com.alimonapps.onlinelibrary.remote.ApiRepository
import com.alimonapps.onlinelibrary.remote.errorhandling.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import javax.inject.Inject

@ExperimentalCoroutinesApi
@HiltViewModel
class BookSearchViewModel
@Inject
constructor(
    app: Application,
    @Book private val apiRepository: ApiRepository,
    private val sharedPrefs: SharedPrefs
) : BaseViewModel(app) {

    val searchInput = MutableLiveData<String>()
    val responseSearch = MutableLiveData<Resource<ResponseAllBooks>>()
    val responseLoadBookSearch = MutableLiveData<ResponseAllBooks>()

    init {
        loadBookData()
    }


    fun getSearchResult(str: String = "") {
        viewModelScope.launch(Dispatchers.IO) {
            val response = apiRepository.getBookList(str)
            responseSearch.postValue(response)
        }
    }

    fun saveBooksData(data: ResponseAllBooks) {
        sharedPrefs.saveBookSearch(data)
    }

    private fun loadBookData() {
        sharedPrefs.loadBookSearch().let {
            responseLoadBookSearch.value = it
        }
    }

}