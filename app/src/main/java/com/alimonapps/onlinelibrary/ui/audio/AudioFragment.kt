package com.alimonapps.onlinelibrary.ui.audio

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.alimonapps.onlinelibrary.databinding.AudioFragmentBinding
import com.alimonapps.onlinelibrary.datamodel.bestpodcast.ResponseBestPodcast
import com.alimonapps.onlinelibrary.ui.main.MainViewModel
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class AudioFragment : Fragment() {

    private val viewModel: AudioViewModel by viewModel()
    private val shareViewModel: MainViewModel by sharedViewModel()
    private val adapter = GroupAdapter<GroupieViewHolder>()
    private lateinit var binding: AudioFragmentBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = AudioFragmentBinding.inflate(inflater)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        //functions
        observeLiveData()


        return binding.root
    }

    private fun observeLiveData() {
        viewModel.loadAudioData()
        viewModel.responseAudioData.observe(viewLifecycleOwner, Observer {
            initRecycler(it)
        })
    }

    private fun initRecycler(responseBestPodcast: ResponseBestPodcast?) {
        val audioList = responseBestPodcast?.podcasts
        val audioListItem = audioList?.map {
            AudioListItem(it) { item ->
                findNavController().navigate(
                    AudioFragmentDirections.actionAudioFragmentToAudioDetailFragment(
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