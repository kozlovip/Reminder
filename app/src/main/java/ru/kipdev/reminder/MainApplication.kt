package ru.kipdev.reminder

import android.app.Activity
import android.app.Application
import ru.kipdev.reminder.di.components.DaggerAppComponent
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import kotlinx.coroutines.InternalCoroutinesApi
import ru.kipdev.reminder.di.components.AppComponent
import javax.inject.Inject


class MainApplication : Application(), HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>
    lateinit var appComponent: AppComponent

    @InternalCoroutinesApi
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .application(this)
            .build()

        appComponent
            .inject(this)
    }


    override fun androidInjector() = dispatchingAndroidInjector
}
