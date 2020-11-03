package com.alimonapps.onlinelibrary.ui.audio

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alimonapps.onlinelibrary.baseclasses.BaseViewModel
import com.alimonapps.onlinelibrary.datamodel.bestpodcast.ResponseBestPodcast
import com.alimonapps.onlinelibrary.livedatahandler.Event
import com.alimonapps.onlinelibrary.local.SharedPrefs

class AudioViewModel(app: Application, private val sharedPrefs: SharedPrefs) : BaseViewModel(app) {

    val responseAudioData = MutableLiveData<ResponseBestPodcast>()


     fun loadAudioData() {
        sharedPrefs.loadAudioData().let {
            responseAudioData.value = it
        }

    }

}