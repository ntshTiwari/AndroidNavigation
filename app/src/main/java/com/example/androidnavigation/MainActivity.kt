package com.example.androidnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController /// will be attached to the drawer to use navigation features
    private lateinit var drawerLayout: DrawerLayout /// the Drawer view
    private lateinit var appBarConfiguration: AppBarConfiguration /// Configuration options for NavigationUI methods that interact with implementations of the app bar pattern

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.main_drawer_layout)

        /// This way of getting navController, didn't work
//        navController = findNavController(R.id.nav_host_fragment_container)

        /// Step 1: get the navController
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        navController = navHostFragment.navController

        /// Step 2: Set the AppBarConfiguration
        appBarConfiguration = AppBarConfiguration(navController.graph, drawerLayout)

        /// Step 3: attach navController to the drawerNavView
        findViewById<NavigationView>(R.id.drawer_nav_view).setupWithNavController(navController)

        /// Step 4: Set up the action bar with the nav controller
        setupActionBarWithNavController(navController, appBarConfiguration)

    }

    /// Step 5: Override the `onSupportNavigateUp` method, to add functionality to the drawer button
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}