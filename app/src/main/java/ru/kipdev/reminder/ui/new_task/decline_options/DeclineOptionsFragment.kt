package ru.kipdev.reminder.ui.new_task.decline_options

import ru.kipdev.reminder.R
import ru.kipdev.reminder.databinding.FragmentDeclineOptionsBinding
import ru.medicalapps.medicalapps.demo.utils.BaseViewModelFragment

class DeclineOptionsFragment : BaseViewModelFragment<FragmentDeclineOptionsBinding, DeclineOptionsViewModel>() {

    override val layoutId: Int
        get() = R.layout.fragment_decline_options

    override val navigationId: Int
        get() = R.id.navigation_decline_options

}