package ru.kipdev.reminder.activities.main

import android.os.Bundle
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import ru.kipdev.local_data.TasksDatabase
import ru.kipdev.reminder.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import dagger.android.AndroidInjection
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import ru.kipdev.reminder.databinding.ActivityMainBinding
import ru.medicalapps.medicalapps.demo.utils.BaseViewModelActivity
import javax.inject.Inject

class MainActivity : BaseViewModelActivity<ActivityMainBinding, MainActivityViewModel>(),
    HasAndroidInjector {
    @Inject
    lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector() = fragmentDispatchingAndroidInjector

    override val layoutId: Int
        get() = R.layout.activity_main

    @Inject
    lateinit var tasksDatabase: TasksDatabase

    private lateinit var appBarConfiguration: AppBarConfiguration

    override val navController by lazy(LazyThreadSafetyMode.NONE) {
        Navigation.findNavController(this, R.id.nav_host_fragment)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        appBarConfiguration = AppBarConfiguration(setOf(R.id.navigation_tasks_list, R.id.navigation_profile))
        setupActionBarWithNavController(navController, appBarConfiguration)

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