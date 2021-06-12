package ru.kipdev.reminder.ui.new_task.geo_triggers

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.kipdev.reminder.R
import ru.kipdev.reminder.databinding.FragmentGeoTriggersBinding
import ru.medicalapps.medicalapps.demo.utils.BaseViewModelFragment

class GeoTriggersFragment : BaseViewModelFragment<FragmentGeoTriggersBinding, GeoTriggersViewModel>() {

    override val layoutId: Int
        get() = R.layout.fragment_geo_triggers

    override val navigationId: Int
        get() = 0
}