package ru.kipdev.reminder.ui.profile.di

import androidx.core.util.Supplier
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import ru.kipdev.reminder.ui.profile.ProfileFragment
import ru.kipdev.reminder.ui.profile.ProfileViewModel
import ru.kipdev.reminder.utils.ViewModelProviderFactory

@Module
class ProfileFragmentModule {
    @Provides
    fun provideProfileModel(fragment: ProfileFragment): ProfileViewModel {
        val supplier: Supplier<ProfileViewModel> =
            Supplier {
                ProfileViewModel()
            }
        val factory: ViewModelProviderFactory<ProfileViewModel> =
            ViewModelProviderFactory(ProfileViewModel::class.java, supplier)
        return ViewModelProvider(fragment, factory).get(ProfileViewModel::class.java)
    }
}