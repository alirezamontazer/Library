package com.alimonapps.onlinelibrary.ui.audio

import android.app.Application
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.alimonapps.onlinelibrary.baseclasses.BaseViewModel
import com.alimonapps.onlinelibrary.datamodel.bestpodcast.ResponseBestPodcast
import com.alimonapps.onlinelibrary.livedatahandler.Event
import com.alimonapps.onlinelibrary.local.SharedPrefs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

@ExperimentalCoroutinesApi
@HiltViewModel
class AudioViewModel
@Inject
constructor(
    app: Application,
    private val sharedPrefs: SharedPrefs
) : BaseViewModel(app) {

    val responseAudioData = MutableLiveData<ResponseBestPodcast>()


    fun loadAudioData() {
        sharedPrefs.loadAudioData().let {
            responseAudioData.value = it
        }

    }

}