package com.alimonapps.onlinelibrary.ui.bookdetail

import android.app.Application
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import com.alimonapps.onlinelibrary.baseclasses.BaseViewModel
import com.alimonapps.onlinelibrary.datamodel.allbooks.VolumeInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

@ExperimentalCoroutinesApi
@HiltViewModel
class BookDetailViewModel
@Inject
constructor(app: Application) :
    BaseViewModel(app) {

    val bookData = MutableLiveData<VolumeInfo>()

}