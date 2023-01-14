package com.example.androidnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.navigation.findNavController

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /// Navigate to the viewPager fragment after 3 seconds
        Handler().postDelayed({
          findNavController(R.id.fragmentContainerView2).navigate(R.id.action_splashFragment_to_viewPagerFragment)
        }, 3000)

        /// we can hide action bar using this command as well
        supportActionBar?.hide()
    }
}