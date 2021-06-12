package ru.medicalapps.medicalapps.demo.utils

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import ru.kipdev.reminder.model.DataResult

abstract class BaseViewModel : ViewModel() {

    open fun onError(th: Throwable){

    }

    protected fun <T>launchCoroutine(liveData: MutableLiveData<DataResult<T>>? = null, block: suspend CoroutineScope.() -> Unit): Job {
        return viewModelScope.launch(CoroutineExceptionHandler { _, throwable ->
            liveData?.let{
                it.value = DataResult.error(throwable)
            }
            onError(throwable)
        }) {
            block()
        }
    }
}