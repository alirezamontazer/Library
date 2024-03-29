package com.alimonapps.onlinelibrary.ui.discover

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.alimonapps.onlinelibrary.R
import com.alimonapps.onlinelibrary.baseclasses.BaseViewModel
import com.alimonapps.onlinelibrary.datamodel.searchaudio.ResponseAudioSearch
import com.alimonapps.onlinelibrary.local.SharedPrefs
import com.alimonapps.onlinelibrary.remote.ApiRepository
import com.alimonapps.onlinelibrary.remote.errorhandling.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AudioSearchViewModel(
    private val app: Application,
    private val apiRepository: ApiRepository,
    private val sharedPrefs: SharedPrefs
) : BaseViewModel(app) {

    private val typeArray = app.resources.getStringArray(R.array.type_array)
    private val languageArray = app.resources.getStringArray(R.array.language_array)
    val selectedType = MutableLiveData<String>()
    val selectedLanguage = MutableLiveData<String>()
    val inputText = MutableLiveData<String>()
    val responseSearchResult = MutableLiveData<Resource<ResponseAudioSearch>>()


    fun getAudioSearch(q: String, type: String, language: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = apiRepository.getAudioSearch(q = q, type = type, language = language)
            responseSearchResult.postValue(response)
        }
    }

    fun setTypeSelected(selectedItem: Int) {
        selectedType.value = typeArray[selectedItem]
    }

    fun setLanguageSelected(selectedLanguageItem: Int) {
        selectedLanguage.value = languageArray[selectedLanguageItem]
    }


}