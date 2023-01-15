package com.example.androidnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.widget.Toolbar
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.transition.AutoTransition
import androidx.transition.TransitionManager
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController
    private lateinit var navView: NavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /// We have a NoActionBar theme by default
        /// so, we add our ToolBar as ActionBar here
        val toolbar = findViewById<Toolbar>(R.id.drawer_toolbar)
        setSupportActionBar(toolbar)

        drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)

        navController = (supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment).navController
        appBarConfiguration = AppBarConfiguration(navController.graph, drawerLayout)

        navView = findViewById<NavigationView>(R.id.drawer_nav_view)
        navView.setupWithNavController(navController)

        setupActionBarWithNavController(navController, appBarConfiguration)

        handleDrawerExpansionTileCode()
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    private fun handleDrawerExpansionTileCode() {
        /// get the 2nd item and its actionLayout and then get the clickable and hidden views out of it
        val item = navView.menu.getItem(2).actionView

        val cardView = item.findViewById<CardView>(R.id.expansion_cardview)
        val alwaysVisibleArea = item.findViewById<LinearLayout>(R.id.expansion_clickable_area)
        val hiddenArea = item.findViewById<LinearLayout>(R.id.expansion_hiddenview)
        val arrow = item.findViewById<View>(R.id.expansion_clickable_arrow)

        alwaysVisibleArea.setOnClickListener {
            /// to add animation for both cases

            TransitionManager.beginDelayedTransition(cardView, AutoTransition())
            if(hiddenArea.visibility == View.VISIBLE){
                hiddenArea.visibility = View.GONE
                arrow.background = ContextCompat.getDrawable(this@MainActivity, R.drawable.ic_down)
            } else {
                hiddenArea.visibility = View.VISIBLE
                arrow.background = ContextCompat.getDrawable(this@MainActivity, R.drawable.ic_up)
            }
        }
    }
}