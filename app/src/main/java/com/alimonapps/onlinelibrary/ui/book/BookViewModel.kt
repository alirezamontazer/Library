package com.alimonapps.onlinelibrary.ui.book

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.alimonapps.onlinelibrary.baseclasses.BaseViewModel
import com.alimonapps.onlinelibrary.datamodel.allbooks.ResponseAllBooks
import com.alimonapps.onlinelibrary.livedatahandler.Event
import com.alimonapps.onlinelibrary.local.SharedPrefs
import timber.log.Timber

class BookViewModel(
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