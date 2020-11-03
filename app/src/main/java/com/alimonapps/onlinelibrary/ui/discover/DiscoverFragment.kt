package com.alimonapps.onlinelibrary.ui.discover

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alimonapps.onlinelibrary.R
import com.alimonapps.onlinelibrary.databinding.DiscoverFragmentBinding
import com.alimonapps.onlinelibrary.ui.book.BookViewModel
import com.alimonapps.onlinelibrary.ui.main.MainViewModel
import com.google.android.material.tabs.TabLayoutMediator
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class DiscoverFragment : Fragment() {

    private val viewModel: DiscoverViewModel by viewModel()
    private val sharedViewModel: MainViewModel by sharedViewModel()
    private lateinit var binding: DiscoverFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DiscoverFragmentBinding.inflate(inflater)

        //functions
        setViewPager()
        setTabLayout()

        return binding.root
    }

    private fun setTabLayout() {

        val tabLayoutMediator = TabLayoutMediator(
            binding.tabLayout, binding.viewPager
        ) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Search Book"
                }
                else -> {
                    tab.text = "Search Audio"
                }

            }
        }.attach()

    }

    private fun setViewPager() {
        binding.viewPager.adapter = ViewPagerAdapter(this)
    }


}