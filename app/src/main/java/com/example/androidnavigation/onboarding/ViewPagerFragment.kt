package com.example.androidnavigation.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.androidnavigation.R
import com.example.androidnavigation.screens.FirstFragment
import com.example.androidnavigation.screens.SecondFragment
import com.example.androidnavigation.screens.ThirdFragment

class ViewPagerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_view_pager, container, false)

        /// Step 1: create a list of all fragments for viewPagerAdapter, to be passed
        val fragmentList = arrayListOf<Fragment>(
            FirstFragment(),
            SecondFragment(),
            ThirdFragment(),
        )

        /// Step 2: Create the viewPagerAdapter
        val adapter = ViewPagerAdapter(
            fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle
        )

        /// Step 3: Attach the viewPagerAdapter
        view.findViewById<ViewPager2>(R.id.view_pager).adapter = adapter

        return view
    }

}