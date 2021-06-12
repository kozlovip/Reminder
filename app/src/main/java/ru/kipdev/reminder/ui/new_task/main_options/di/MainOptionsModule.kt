package ru.kipdev.reminder.ui.new_task.main_options.di

import androidx.core.util.Supplier
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import ru.kipdev.reminder.ui.new_task.main_options.MainOptionsFragment
import ru.kipdev.reminder.ui.new_task.main_options.MainOptionsViewModel
import ru.kipdev.reminder.utils.ViewModelProviderFactory

@Module
class MainOptionsModule {
    @Provides
    fun provideMainOptionsModel(fragment: MainOptionsFragment): MainOptionsViewModel {
        val supplier: Supplier<MainOptionsViewModel> =
            Supplier {
                MainOptionsViewModel()
            }
        val factory: ViewModelProviderFactory<MainOptionsViewModel> =
            ViewModelProviderFactory(MainOptionsViewModel::class.java, supplier)
        return ViewModelProvider(fragment, factory).get(MainOptionsViewModel::class.java)
    }
}