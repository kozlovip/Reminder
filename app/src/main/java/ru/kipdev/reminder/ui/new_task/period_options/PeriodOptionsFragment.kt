package ru.kipdev.reminder.ui.new_task.period_options

import ru.kipdev.reminder.R
import ru.kipdev.reminder.databinding.FragmentPeriodOptionsBinding
import ru.medicalapps.medicalapps.demo.utils.BaseViewModelFragment

class PeriodOptionsFragment : BaseViewModelFragment<FragmentPeriodOptionsBinding, PeriodOptionsViewModel>() {

    override val layoutId: Int
        get() = R.layout.fragment_period_options

    override val navigationId: Int
        get() = 0
}