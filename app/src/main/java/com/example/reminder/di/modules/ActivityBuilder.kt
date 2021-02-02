package com.example.reminder.di.modules

import com.example.reminder.di.scopes.ActivityScope
import com.example.reminder.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {
    @ActivityScope
    @ContributesAndroidInjector(
        modules = []
    )
    abstract fun bindMainActivity(): MainActivity
}