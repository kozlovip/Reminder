package ru.kipdev.reminder

import android.app.Activity
import android.app.Application
import ru.kipdev.local_data.TasksDatabase
import ru.kipdev.reminder.di.components.DaggerAppComponent
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import kotlinx.coroutines.InternalCoroutinesApi
import javax.inject.Inject


class MainApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    @InternalCoroutinesApi
    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder()
            .application(this)
            .build()
            .inject(this)
    }

    override fun activityInjector() = dispatchingAndroidInjector
}
