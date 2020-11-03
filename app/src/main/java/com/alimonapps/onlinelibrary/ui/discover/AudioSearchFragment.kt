package com.alimonapps.onlinelibrary.ui.discover

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alimonapps.onlinelibrary.R

class AudioSearchFragment : Fragment() {

    companion object {
        fun newInstance() = AudioSearchFragment()
    }

    private lateinit var viewModel: AudioSearchViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.audio_search_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AudioSearchViewModel::class.java)
        // TODO: Use the ViewModel
    }

}