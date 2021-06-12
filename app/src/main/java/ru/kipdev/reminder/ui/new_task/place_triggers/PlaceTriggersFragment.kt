package ru.kipdev.reminder.ui.new_task.place_triggers

import ru.kipdev.reminder.R
import ru.kipdev.reminder.databinding.FragmentPlaceTriggersBinding
import ru.medicalapps.medicalapps.demo.utils.BaseViewModelFragment

class PlaceTriggersFragment : BaseViewModelFragment<FragmentPlaceTriggersBinding, PlaceTriggersViewModel>() {

    override val layoutId: Int
        get() = R.layout.fragment_place_triggers

    override val navigationId: Int
        get() = R.id.navigation_place_triggers
}