package ru.kipdev.reminder.ui.new_task.decline_options.di

import androidx.core.util.Supplier
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import ru.kipdev.reminder.ui.new_task.decline_options.DeclineOptionsFragment
import ru.kipdev.reminder.ui.new_task.decline_options.DeclineOptionsViewModel
import ru.kipdev.reminder.utils.ViewModelProviderFactory

@Module
class DeclineOptionsModule {
    @Provides
    fun provideDeclineOptionsModel(fragment: DeclineOptionsFragment): DeclineOptionsViewModel {
        val supplier: Supplier<DeclineOptionsViewModel> =
            Supplier {
                DeclineOptionsViewModel()
            }
        val factory: ViewModelProviderFactory<DeclineOptionsViewModel> =
            ViewModelProviderFactory(DeclineOptionsViewModel::class.java, supplier)
        return ViewModelProvider(fragment, factory).get(DeclineOptionsViewModel::class.java)
    }
}