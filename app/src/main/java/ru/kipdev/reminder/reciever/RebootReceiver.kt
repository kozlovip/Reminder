package ru.kipdev.reminder.reciever

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import dagger.android.AndroidInjection
import ru.kipdev.reminder.manager.TasksManager
import javax.inject.Inject

class RebootReceiver : BroadcastReceiver() {

    @Inject
    lateinit var tasksManager: TasksManager

    override fun onReceive(context: Context, intent: Intent) {
        AndroidInjection.inject(this, context)
        val action = intent.action
        Log.d("TestReC", action!!)
        tasksManager.insertTest(action.toString())
    }
}