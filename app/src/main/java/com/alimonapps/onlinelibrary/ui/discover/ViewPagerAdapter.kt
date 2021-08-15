package com.alimonapps.onlinelibrary.ui.discover

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import timber.log.Timber

@ExperimentalCoroutinesApi
class ViewPagerAdapter(discoverFragment: DiscoverFragment) :
    FragmentStateAdapter(discoverFragment) {


    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> BookSearchFragment()
            else -> AudioSearchFragment()
        }
    }

}
