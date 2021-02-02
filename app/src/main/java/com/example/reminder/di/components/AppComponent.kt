package com.example.reminder.di.components

import com.example.reminder.MainApplication
import com.example.reminder.di.modules.AppModule
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(app: MainApplication)
}
