package ru.kipdev.reminder.utils

import androidx.core.util.Supplier
import androidx.lifecycle.ViewModelProvider
import ru.kipdev.reminder.ui.new_task.main_options.MainOptionsFragment
import ru.kipdev.reminder.ui.new_task.main_options.MainOptionsViewModel
import ru.medicalapps.medicalapps.demo.utils.BaseViewModel

/*fun <T>provideMainOptionsModel(fragment: MainOptionsFragment, viewModel: BaseViewModel): BaseViewModel {
    val supplier: Supplier<T> =
        Supplier {
            T()
        }
    val factory: ViewModelProviderFactory<BaseViewModel> =
        ViewModelProviderFactory(BaseViewModel::class.java, supplier)
    return ViewModelProvider(fragment, factory).get(viewModel::class.java)
}*/