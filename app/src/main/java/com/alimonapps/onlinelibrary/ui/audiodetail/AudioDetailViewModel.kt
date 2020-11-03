package com.alimonapps.onlinelibrary.ui.audiodetail

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alimonapps.onlinelibrary.baseclasses.BaseViewModel
import com.alimonapps.onlinelibrary.datamodel.bestpodcast.Podcast
import com.alimonapps.onlinelibrary.local.SharedPrefs

class AudioDetailViewModel(app: Application, private val sharedPrefs: SharedPrefs) :
    BaseViewModel(app) {

    val audioData = MutableLiveData<Podcast>()

}