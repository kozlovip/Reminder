package ru.kipdev.reminder.ui.new_task.dismiss_options

import ru.kipdev.reminder.R
import ru.kipdev.reminder.databinding.FragmentDismissOptionsBinding
import ru.kipdev.reminder.utils.BaseViewModelFragment

class DismissOptionsFragment : BaseViewModelFragment<FragmentDismissOptionsBinding, DismissOptionsViewModel>() {

    override val layoutId: Int
        get() = R.layout.fragment_dismiss_options

    override val navigationId: Int
        get() = R.id.navigation_dismiss_options
}