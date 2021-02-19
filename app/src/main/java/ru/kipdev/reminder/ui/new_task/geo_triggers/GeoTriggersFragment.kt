package ru.kipdev.reminder.ui.new_task.geo_triggers

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.kipdev.reminder.R

class GeoTriggersFragment : Fragment() {

    companion object {
        fun newInstance() = GeoTriggersFragment()
    }

    private lateinit var viewModel: GeoTriggersViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.geo_triggers_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(GeoTriggersViewModel::class.java)
        // TODO: Use the ViewModel
    }

}