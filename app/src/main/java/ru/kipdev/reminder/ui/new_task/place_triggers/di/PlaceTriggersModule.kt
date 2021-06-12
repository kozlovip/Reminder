package ru.kipdev.reminder.ui.new_task.place_triggers.di

import androidx.core.util.Supplier
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import ru.kipdev.reminder.ui.new_task.place_triggers.PlaceTriggersFragment
import ru.kipdev.reminder.ui.new_task.place_triggers.PlaceTriggersViewModel
import ru.kipdev.reminder.utils.ViewModelProviderFactory

@Module
class PlaceTriggersModule {
    @Provides
    fun providePlaceTriggersModel(fragment: PlaceTriggersFragment): PlaceTriggersViewModel {
        val supplier: Supplier<PlaceTriggersViewModel> =
            Supplier {
                PlaceTriggersViewModel()
            }
        val factory: ViewModelProviderFactory<PlaceTriggersViewModel> =
            ViewModelProviderFactory(PlaceTriggersViewModel::class.java, supplier)
        return ViewModelProvider(fragment, factory).get(PlaceTriggersViewModel::class.java)
    }
}