package com.alimonapps.onlinelibrary.ui.bookdetail

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alimonapps.onlinelibrary.baseclasses.BaseViewModel
import com.alimonapps.onlinelibrary.datamodel.allbooks.VolumeInfo
import com.alimonapps.onlinelibrary.local.SharedPrefs

class BookDetailViewModel(app: Application, private val sharedPrefs: SharedPrefs) :
    BaseViewModel(app) {

    val bookData = MutableLiveData<VolumeInfo>()

}