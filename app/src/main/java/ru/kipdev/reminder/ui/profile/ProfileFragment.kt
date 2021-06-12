package ru.kipdev.reminder.ui.profile

import ru.kipdev.reminder.R
import ru.kipdev.reminder.databinding.FragmentProfileBinding
import ru.medicalapps.medicalapps.demo.utils.BaseViewModelFragment

class ProfileFragment : BaseViewModelFragment<FragmentProfileBinding, ProfileViewModel>() {
    override val layoutId: Int
        get() = R.layout.fragment_profile

    override val navigationId: Int
        get() = R.id.navigation_profile
}