package com.alimonapps.onlinelibrary.ui.discover

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.alimonapps.onlinelibrary.databinding.DiscoverFragmentBinding
import com.google.android.material.tabs.TabLayoutMediator

class DiscoverFragment : Fragment() {

    private lateinit var binding: DiscoverFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
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