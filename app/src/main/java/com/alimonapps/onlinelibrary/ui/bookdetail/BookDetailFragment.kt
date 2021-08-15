package com.alimonapps.onlinelibrary.ui.bookdetail

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
import com.alimonapps.onlinelibrary.databinding.BookDetailFragmentBinding
import com.alimonapps.onlinelibrary.ui.main.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.android.ext.android.bind
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class BookDetailFragment : Fragment() {

    private val viewModel: BookDetailViewModel by viewModels()
    private lateinit var binding: BookDetailFragmentBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = BookDetailFragmentBinding.inflate(inflater)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        //functions
        loadData()
        clickOnMoreInfo()


        return binding.root
    }

    private fun clickOnMoreInfo() {
        binding.btnMoreInfo.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(viewModel.bookData.value?.infoLink))
            startActivity(intent)
        }

    }

    private fun loadData() {
        val bundle = arguments?.let { BookDetailFragmentArgs.fromBundle(it) }
        viewModel.bookData.value = bundle?.bookData

    }


}