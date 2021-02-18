package com.example.reminder.ui.new_task.main_options

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.reminder.R
import com.example.reminder.model.TaskOptionPresentation

class MainOptionsViewModel : ViewModel() {
    private val _taskOptions = MutableLiveData<List<TaskOptionPresentation>>().apply {
        val l = ArrayList<TaskOptionPresentation>()
        l.add(TaskOptionPresentation(0, R.string.text_alarm_clock, R.drawable.ic_notifications_black_24dp))
        l.add(TaskOptionPresentation(1, R.string.text_shopping, R.drawable.ic_notifications_black_24dp))
        l.add(TaskOptionPresentation(2, R.string.text_place_alarm, R.drawable.ic_notifications_black_24dp))
        l.add(TaskOptionPresentation(3, R.string.text_notification, R.drawable.ic_notifications_black_24dp))
        l.add(TaskOptionPresentation(4, R.string.text_custom_task, R.drawable.ic_dashboard_black_24dp))
        value = l
    }
    val firstStageTaskOptions: LiveData<List<TaskOptionPresentation>> = _taskOptions
}