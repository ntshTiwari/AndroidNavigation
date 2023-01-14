package com.example.androidnavigation.screens

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.androidnavigation.R

class ThirdFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_third, container, false)

        /// Get the viewPager associated with this activity
        val viewPager2 = activity?.findViewById<ViewPager2>(R.id.view_pager)

        view.findViewById<TextView>(R.id.third_fragment_finish).setOnClickListener {
            onBoardingFinished();
            /// we are moving to home fragment when finish is pressed
            findNavController().navigate(R.id.action_viewPagerFragment_to_homeScreen)
        }

        return view
    }

    /// When a user presses "Finish" button , that means he has onboarded successfully
    /// So, we will store this data in our shared preferences
    /// and use it at subsequent startups of the app
    private fun onBoardingFinished() {
        val sharedPreferences = requireActivity().getSharedPreferences("onboarding", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putBoolean("Finished", true)
        editor.apply()
    }
}