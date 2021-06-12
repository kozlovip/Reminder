package ru.kipdev.reminder.ui.new_task.time_options.di

import androidx.core.util.Supplier
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import ru.kipdev.reminder.ui.new_task.time_options.TimeOptionsFragment
import ru.kipdev.reminder.ui.new_task.time_options.TimeOptionsViewModel
import ru.kipdev.reminder.utils.ViewModelProviderFactory

@Module
class TimeOptionsModule {
    @Provides
    fun provideTimeOptionsModel(fragment: TimeOptionsFragment): TimeOptionsViewModel {
        val supplier: Supplier<TimeOptionsViewModel> =
            Supplier {
                TimeOptionsViewModel()
            }
        val factory: ViewModelProviderFactory<TimeOptionsViewModel> =
            ViewModelProviderFactory(TimeOptionsViewModel::class.java, supplier)
        return ViewModelProvider(fragment, factory).get(TimeOptionsViewModel::class.java)
    }
}