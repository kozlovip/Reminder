package com.example.reminder

import android.app.Application
import com.example.reminder.di.components.AppComponent
import com.example.reminder.di.components.DaggerAppComponent
import com.example.reminder.di.modules.AppModule

class MainApplication : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()

        appComponent.inject(this)
    }
}