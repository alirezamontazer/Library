package com.alimonapps.onlinelibrary.ui.audiodetail

import android.content.Intent
import android.net.Uri
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.alimonapps.onlinelibrary.R
import com.alimonapps.onlinelibrary.databinding.AudioDetailFragmentBinding
import com.alimonapps.onlinelibrary.ui.main.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class AudioDetailFragment : Fragment() {

    private val viewModel: AudioDetailViewModel by viewModels()
    private lateinit var binding: AudioDetailFragmentBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = AudioDetailFragmentBinding.inflate(inflater)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        //functions
        loadData()
        clickOnMoreInfo()

        return binding.root
    }

    private fun clickOnMoreInfo() {
        binding.btnMoreInfo.setOnClickListener {
            if (viewModel.isSearchData.value == true) {
                val intent =
                    Intent(Intent.ACTION_VIEW, Uri.parse(viewModel.searchAudioData.value?.website))
                startActivity(intent)
            } else {
                val intent =
                    Intent(Intent.ACTION_VIEW, Uri.parse(viewModel.audioData.value?.website))
                startActivity(intent)
            }

        }

    }

    private fun loadData() {
        val bundle = arguments?.let { AudioDetailFragmentArgs.fromBundle(it) }
        viewModel.audioData.value = bundle?.audioData
        viewModel.searchAudioData.value = bundle?.searchAudioData
        if (viewModel.searchAudioData.value != null) {
            viewModel.isSearchData.value = true
        }
        if (viewModel.audioData.value != null) {
            viewModel.isSearchData.value = false
        }
    }


}