package com.example.androidnavigation

import android.content.Context
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController

class SplashFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        /// Navigate to the viewPager fragment after 3 seconds
        Handler().postDelayed({
            if(isAlreadyOnboarded()){
                findNavController().navigate(R.id.action_splashFragment_to_homeScreen)
            } else {
                findNavController().navigate(R.id.action_splashFragment_to_viewPagerFragment)
            }
        }, 3000)


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    /// If the use has already onboarded, we do not show him the onboarding flow again
    private fun isAlreadyOnboarded(): Boolean {
        val sharedPreferences = requireActivity().getSharedPreferences("onboarding", Context.MODE_PRIVATE)

        /// we check for the key `Finished`, with a default value of false
        return sharedPreferences.getBoolean("Finished", false)
    }
}