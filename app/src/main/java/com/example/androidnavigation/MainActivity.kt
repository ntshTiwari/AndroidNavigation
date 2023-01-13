package com.example.androidnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavHost
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /// Step 1: Get the bottomNavigationView
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_nav_view)

        /// Step 2: get the navController
        val navController = (supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHost).navController

        /// Attach the navController to the bottomNavigationView using the setupWithNavController function
        bottomNavigationView.setupWithNavController(navController)
    }
}