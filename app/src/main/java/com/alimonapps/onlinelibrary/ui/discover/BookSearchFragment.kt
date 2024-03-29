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
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.alimonapps.onlinelibrary.R
import com.alimonapps.onlinelibrary.databinding.BookSearchFragmentBinding
import com.alimonapps.onlinelibrary.datamodel.allbooks.ResponseAllBooks
import com.alimonapps.onlinelibrary.remote.errorhandling.Status
import com.alimonapps.onlinelibrary.ui.book.BookFragmentDirections
import com.alimonapps.onlinelibrary.ui.book.BookListItem
import com.alimonapps.onlinelibrary.ui.main.MainViewModel
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class BookSearchFragment : Fragment() {

    private val viewModel: BookSearchViewModel by viewModel()
    private val sharedViewModel: MainViewModel by sharedViewModel()
    private val adapter = GroupAdapter<GroupieViewHolder>()
    private lateinit var binding: BookSearchFragmentBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = BookSearchFragmentBinding.inflate(inflater)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        //functions
        observeLiveData()
        clickOnSearchBtn()


        return binding.root
    }

    private fun observeLiveData() {

        viewModel.responseLoadBookSearch.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                initRecycler(it)
            }
        })

    }


    private fun clickOnSearchBtn() {
        binding.imgSearch.setOnClickListener {

            viewModel.searchInput.value.let {
                if (it != null && it.isNotEmpty()) {

                    //hide keyboard
                    val inputManager =
                        requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    inputManager.hideSoftInputFromWindow(binding.edtSearch.windowToken, 0)

                    viewModel.getSearchResult(str = it)
                    viewModel.responseSearch.observe(viewLifecycleOwner, Observer { item ->

                        if (item.status == Status.SUCCESS) {
                            viewModel.saveBooksData(item.data!!)
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

    private fun initRecycler(responseAllBooks: ResponseAllBooks?) {
        val bookList = responseAllBooks?.items
        val bookListItem = bookList?.map {
            BookListItem(it) { item ->
                findNavController().navigate(
                    DiscoverFragmentDirections.actionDiscoverFragmentToBookDetailFragment(
                        item
                    )
                )

            }
        }
        if (bookListItem != null) {
            adapter.clear()
            adapter.addAll(bookListItem)
            binding.rcBook.adapter = adapter
        }

    }


}