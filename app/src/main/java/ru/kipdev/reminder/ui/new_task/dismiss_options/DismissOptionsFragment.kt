package ru.kipdev.reminder.ui.new_task.dismiss_options

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.kipdev.reminder.R
import ru.kipdev.reminder.databinding.FragmentDismissOptionsBinding
import ru.medicalapps.medicalapps.demo.utils.BaseViewModelFragment

class DismissOptionsFragment : BaseViewModelFragment<FragmentDismissOptionsBinding, DismissOptionsViewModel>() {

    override val layoutId: Int
        get() = R.layout.fragment_dismiss_options

    override val navigationId: Int
        get() = R.id.navigation_dismiss_options
}