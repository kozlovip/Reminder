package ru.kipdev.domain.model

import ru.kipdev.domain.utils.DURATION_TYPE


data class TimeTrigger (
    val times: List<Time>,
    val scheme: TimeScheme
)

open class TimeScheme {
    data class SchemeWeekDays(
        val weekDays: List<Int>
    ) : TimeScheme()
    data class SchemeInterval(
        val triggerInterval: Int = 1,
        val skipInterval: Int = 1,
        var intervalType: DURATION_TYPE = DURATION_TYPE.DAYS
    ) : TimeScheme()
}

data class Time(
    var hour: Int,
    var minute: Int
)