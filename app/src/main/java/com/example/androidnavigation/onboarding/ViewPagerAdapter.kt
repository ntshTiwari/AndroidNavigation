package com.example.androidnavigation.onboarding

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

/// this is the adapter of our viewpager,
/// just like the adapter of a recyclerview
class ViewPagerAdapter(
    list: ArrayList<Fragment>,
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
): FragmentStateAdapter(fragmentManager, lifecycle) {

    /// as list is not a member of the class, we have to use it like this
    /// if list would have been defined like `val list: ArrayList<Fragment>`, then it would be a member
    private val fragmentList = list

    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
       return fragmentList[position]
    }

}