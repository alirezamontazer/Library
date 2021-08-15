package com.alimonapps.onlinelibrary.ui.book

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.alimonapps.onlinelibrary.baseclasses.BaseViewModel
import com.alimonapps.onlinelibrary.datamodel.allbooks.ResponseAllBooks
import com.alimonapps.onlinelibrary.local.SharedPrefs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

@ExperimentalCoroutinesApi
@HiltViewModel
class BookViewModel
@Inject
constructor(
    app: Application,
    private val sharedPrefs: SharedPrefs
) : BaseViewModel(app) {

    val responseBookData = MutableLiveData<ResponseAllBooks>()


    fun loadBookData() {
        sharedPrefs.loadBooksData().let {
            responseBookData.value = it
        }
    }

}