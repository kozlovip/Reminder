package ru.kipdev.reminder.ui.new_task.time_options

import ru.kipdev.reminder.R
import ru.kipdev.reminder.databinding.FragmentTimeOptionsBinding
import ru.kipdev.reminder.utils.BaseViewModelFragment

class TimeOptionsFragment : BaseViewModelFragment<FragmentTimeOptionsBinding, TimeOptionsViewModel>() {

    override val layoutId: Int
        get() = R.layout.fragment_time_options

    override val navigationId: Int
        get() = R.id.navigation_time_options
}