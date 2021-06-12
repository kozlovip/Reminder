package ru.kipdev.reminder.ui.new_task.period_options.di

import androidx.core.util.Supplier
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import ru.kipdev.reminder.ui.new_task.period_options.PeriodOptionsFragment
import ru.kipdev.reminder.ui.new_task.period_options.PeriodOptionsViewModel
import ru.kipdev.reminder.utils.ViewModelProviderFactory

@Module
class PeriodOptionsModule {
    @Provides
    fun providePeriodOptionsModel(fragment: PeriodOptionsFragment): PeriodOptionsViewModel {
        val supplier: Supplier<PeriodOptionsViewModel> =
            Supplier {
                PeriodOptionsViewModel()
            }
        val factory: ViewModelProviderFactory<PeriodOptionsViewModel> =
            ViewModelProviderFactory(PeriodOptionsViewModel::class.java, supplier)
        return ViewModelProvider(fragment, factory).get(PeriodOptionsViewModel::class.java)
    }
}