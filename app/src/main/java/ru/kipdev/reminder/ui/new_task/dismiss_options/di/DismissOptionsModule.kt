package ru.kipdev.reminder.ui.new_task.dismiss_options.di

import androidx.core.util.Supplier
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import ru.kipdev.reminder.ui.new_task.dismiss_options.DismissOptionsFragment
import ru.kipdev.reminder.ui.new_task.dismiss_options.DismissOptionsViewModel
import ru.kipdev.reminder.utils.ViewModelProviderFactory

@Module
class DismissOptionsModule {
    @Provides
    fun provideDismissOptionsModel(fragment: DismissOptionsFragment): DismissOptionsViewModel {
        val supplier: Supplier<DismissOptionsViewModel> =
            Supplier {
                DismissOptionsViewModel()
            }
        val factory: ViewModelProviderFactory<DismissOptionsViewModel> =
            ViewModelProviderFactory(DismissOptionsViewModel::class.java, supplier)
        return ViewModelProvider(fragment, factory).get(DismissOptionsViewModel::class.java)
    }
}