package ru.kipdev.reminder.di.modules

import ru.kipdev.reminder.di.scopes.ActivityScope
import ru.kipdev.reminder.activities.MainActivity
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