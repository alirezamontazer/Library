package com.alimonapps.onlinelibrary.ui.audiodetail

import android.app.Application
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import com.alimonapps.onlinelibrary.baseclasses.BaseViewModel
import com.alimonapps.onlinelibrary.datamodel.bestpodcast.Podcast
import com.alimonapps.onlinelibrary.datamodel.searchaudio.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

@ExperimentalCoroutinesApi
@HiltViewModel
class AudioDetailViewModel
@Inject
constructor(app: Application) :
    BaseViewModel(app) {

    val audioData = MutableLiveData<Podcast>()
    val searchAudioData = MutableLiveData<Result>()
    val isSearchData = MutableLiveData<Boolean>(false)

}