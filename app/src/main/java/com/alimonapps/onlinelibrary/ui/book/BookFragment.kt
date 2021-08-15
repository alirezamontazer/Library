package com.alimonapps.onlinelibrary.ui.book

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.alimonapps.onlinelibrary.databinding.BookFragmentBinding
import com.alimonapps.onlinelibrary.datamodel.allbooks.ResponseAllBooks
import com.alimonapps.onlinelibrary.ui.main.MainViewModel
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class BookFragment : Fragment() {

    private val viewModel: BookViewModel by viewModels()
    private val adapter = GroupAdapter<GroupieViewHolder>()
    private lateinit var binding: BookFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = BookFragmentBinding.inflate(inflater)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        //functions
        observeLiveData()


        return binding.root

    }

    private fun observeLiveData() {
        viewModel.loadBookData()
        viewModel.responseBookData.observe(viewLifecycleOwner, Observer {
            initRecycler(it)
        })
    }

    private fun initRecycler(responseAllBooks: ResponseAllBooks) {
        val bookList = responseAllBooks.items
        val bookListItem = bookList?.map {
            BookListItem(it) { item ->
                findNavController().navigate(
                    BookFragmentDirections.actionBookFragmentToBookDetailFragment(
                        item
                    )
                )
            }
        }
        if (bookListItem != null) {
            adapter.addAll(bookListItem)
            binding.rcBook.adapter = adapter
        }

    }

}