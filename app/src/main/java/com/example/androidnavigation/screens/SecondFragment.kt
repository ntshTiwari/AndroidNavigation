package com.example.androidnavigation.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.viewpager2.widget.ViewPager2
import com.example.androidnavigation.R

class SecondFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_second, container, false)

        /// Get the viewPager associated with this activity
        val viewPager2 = activity?.findViewById<ViewPager2>(R.id.view_pager)

        view.findViewById<TextView>(R.id.second_fragment_next).setOnClickListener {
            /// we are assigning the new item number when next is pressed
//            viewPager2?.currentItem = 2
            viewPager2?.currentItem = viewPager2?.currentItem?.inc()!!
        }

        return view

    }
}