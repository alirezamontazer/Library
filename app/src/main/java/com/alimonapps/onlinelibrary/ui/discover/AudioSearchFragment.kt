package com.alimonapps.onlinelibrary.ui.discover

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.alimonapps.onlinelibrary.R
import com.alimonapps.onlinelibrary.databinding.AudioSearchFragmentBinding
import com.alimonapps.onlinelibrary.datamodel.searchaudio.ResponseAudioSearch
import com.alimonapps.onlinelibrary.remote.errorhandling.Status
import com.alimonapps.onlinelibrary.ui.audio.AudioListItem
import com.alimonapps.onlinelibrary.ui.main.MainViewModel
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.android.ext.android.bind
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class AudioSearchFragment : Fragment() {

    private val viewModel: AudioSearchViewModel by viewModels()
    private lateinit var binding: AudioSearchFragmentBinding
    private val adapter = GroupAdapter<GroupieViewHolder>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = AudioSearchFragmentBinding.inflate(inflater)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        //functions
        clickOnSearchBtn()

        return binding.root
    }

    private fun clickOnSearchBtn() {
        binding.imgSearch.setOnClickListener {

            viewModel.inputText.value.let {
                if (it != null && it.isNotEmpty()) {

                    //hide keyboard
                    val inputManager =
                        requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    inputManager.hideSoftInputFromWindow(binding.edtSearch.windowToken, 0)

                    viewModel.getAudioSearch(
                        q = it,
                        viewModel.selectedType.value!!,
                        viewModel.selectedLanguage.value!!
                    )

                    viewModel.responseSearchResult.observe(viewLifecycleOwner, Observer { item ->
                        if (item.status == Status.SUCCESS) {
                            initRecycler(item.data)
                        } else {
                            Toast.makeText(requireContext(), item.message, Toast.LENGTH_SHORT)
                                .show()
                        }

                    })
                }
            }
        }
    }

    private fun initRecycler(responseAudioSearch: ResponseAudioSearch?) {
        val audioList = responseAudioSearch?.results
        val audioListItem = audioList?.map {
            AudioSearchItem(it) { item ->
                findNavController().navigate(
                    DiscoverFragmentDirections.actionDiscoverFragmentToAudioDetailFragment(
                        null,
                        item
                    )
                )
            }
        }
        if (audioListItem != null) {
            adapter.addAll(audioListItem)
            binding.rcAudio.adapter = adapter
        }
    }


}