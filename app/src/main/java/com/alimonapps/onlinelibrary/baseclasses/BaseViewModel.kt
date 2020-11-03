package com.alimonapps.onlinelibrary.baseclasses

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

open class BaseViewModel(app: Application) : AndroidViewModel(app) {

    val isShowLoading = MutableLiveData<Boolean>(false)
    val errorMessage = MutableLiveData<String>()
    val message = MutableLiveData<String>()
}