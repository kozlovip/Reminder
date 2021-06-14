package ru.kipdev.reminder.ui.new_task.geo_triggers

import ru.kipdev.reminder.R
import ru.kipdev.reminder.databinding.FragmentGeoTriggersBinding
import ru.kipdev.reminder.utils.BaseViewModelFragment

class GeoTriggersFragment : BaseViewModelFragment<FragmentGeoTriggersBinding, GeoTriggersViewModel>() {

    override val layoutId: Int
        get() = R.layout.fragment_geo_triggers

    override val navigationId: Int
        get() = 0
}