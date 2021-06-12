package ru.kipdev.reminder.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.kipdev.reminder.di.scopes.FragmentScope
import ru.kipdev.reminder.ui.new_task.decline_options.DeclineOptionsFragment
import ru.kipdev.reminder.ui.new_task.decline_options.di.DeclineOptionsModule
import ru.kipdev.reminder.ui.new_task.dismiss_options.DismissOptionsFragment
import ru.kipdev.reminder.ui.new_task.dismiss_options.di.DismissOptionsModule
import ru.kipdev.reminder.ui.new_task.geo_triggers.GeoTriggersFragment
import ru.kipdev.reminder.ui.new_task.geo_triggers.di.GeoTriggersModule
import ru.kipdev.reminder.ui.new_task.main_options.MainOptionsFragment
import ru.kipdev.reminder.ui.new_task.main_options.di.MainOptionsModule
import ru.kipdev.reminder.ui.new_task.period_options.PeriodOptionsFragment
import ru.kipdev.reminder.ui.new_task.period_options.di.PeriodOptionsModule
import ru.kipdev.reminder.ui.new_task.place_triggers.PlaceTriggersFragment
import ru.kipdev.reminder.ui.new_task.place_triggers.di.PlaceTriggersModule
import ru.kipdev.reminder.ui.new_task.time_options.TimeOptionsFragment
import ru.kipdev.reminder.ui.new_task.time_options.di.TimeOptionsModule
import ru.kipdev.reminder.ui.profile.ProfileFragment
import ru.kipdev.reminder.ui.profile.di.ProfileFragmentModule
import ru.kipdev.reminder.ui.tasks_list.TasksListFragment
import ru.kipdev.reminder.ui.tasks_list.di.TasksListModule

@Module
abstract class MainActivityFragmentModule {
    @ContributesAndroidInjector(modules = [DeclineOptionsModule::class])
    @FragmentScope
    abstract fun provideDeclineOptionsFragment(): DeclineOptionsFragment

    @ContributesAndroidInjector(modules = [DismissOptionsModule::class])
    @FragmentScope
    abstract fun provideDismissOptionsFragment(): DismissOptionsFragment

    @ContributesAndroidInjector(modules = [GeoTriggersModule::class])
    @FragmentScope
    abstract fun provideGeoTriggersFragment(): GeoTriggersFragment

    @ContributesAndroidInjector(modules = [MainOptionsModule::class])
    @FragmentScope
    abstract fun provideMainOptionsFragment(): MainOptionsFragment

    @ContributesAndroidInjector(modules = [PeriodOptionsModule::class])
    @FragmentScope
    abstract fun providePeriodOptionsFragment(): PeriodOptionsFragment

    @ContributesAndroidInjector(modules = [PlaceTriggersModule::class])
    @FragmentScope
    abstract fun providePlaceTriggersFragment(): PlaceTriggersFragment

    @ContributesAndroidInjector(modules = [TimeOptionsModule::class])
    @FragmentScope
    abstract fun provideTimeOptionsFragment(): TimeOptionsFragment

    @ContributesAndroidInjector(modules = [ProfileFragmentModule::class])
    @FragmentScope
    abstract fun provideProfileFragmentFragment(): ProfileFragment

    @ContributesAndroidInjector(modules = [TasksListModule::class])
    @FragmentScope
    abstract fun provideTasksListFragment(): TasksListFragment
}