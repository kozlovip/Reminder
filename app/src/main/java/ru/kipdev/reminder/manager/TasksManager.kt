package ru.kipdev.reminder.manager

import android.content.Context
import kotlinx.coroutines.*
import ru.kipdev.domain.usecases.InsertTestUseCase
import java.util.*
import javax.inject.Inject

class TasksManager @Inject constructor(val context: Context, val insertTestUseCase: InsertTestUseCase) {
    private var coroutineScope: CoroutineScope = GlobalScope + SupervisorJob()

    fun insertTest(log: String){
        val cal = Calendar.getInstance()
        val date = cal.timeInMillis
        //val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
        coroutineScope.launch {
            insertTestUseCase("hui", log)
        }
    }
}