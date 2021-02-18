package com.example.reminder.activities

import android.os.Bundle
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.local_data.TasksDatabase
import com.example.reminder.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var tasksDatabase: TasksDatabase

    private val navController by lazy(LazyThreadSafetyMode.NONE) {
        Navigation.findNavController(this, R.id.nav_host_fragment)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_tasks_list, R.id.navigation_profile))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        val fab = findViewById<FloatingActionButton>(R.id.fab_new_task)
        fab.setOnClickListener {
            navController.currentDestination?.id?.let{ destination ->
                when(destination){
                    R.id.navigation_tasks_list ->
                        navController.navigate(R.id.action_navigation_tasks_list_to_navigation_new_task)
                    R.id.navigation_profile ->
                        navController.navigate(R.id.action_navigation_profile_to_navigation_new_task)
                    else ->
                        navController.navigate(R.id.navigation_new_task)
                }
            }
        }

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when(destination.id){
                R.id.navigation_tasks_list -> showBottomNav()
                R.id.navigation_profile -> showBottomNav()
                else -> hideBottomNav()
            }
        }
    }

    private fun showBottomNav() {
        val coordinator: CoordinatorLayout = findViewById(R.id.coordinator)
        coordinator.visibility = View.VISIBLE
    }

    private fun hideBottomNav() {
        val coordinator: CoordinatorLayout = findViewById(R.id.coordinator)
        coordinator.visibility = View.GONE
    }

    override fun onSupportNavigateUp() = navController.navigateUp()
}