package com.example.reminder.ui.new_task

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NewTaskViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is newTask Fragment"
    }
    val text: LiveData<String> = _text
}