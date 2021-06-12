package ru.kipdev.domain.utils

import java.util.*

val allDays = arrayListOf(Calendar.MONDAY, Calendar.TUESDAY, Calendar.WEDNESDAY, Calendar.THURSDAY, Calendar.FRIDAY, Calendar.SATURDAY, Calendar.SUNDAY)

enum class DURATION_TYPE {
    SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS
}

enum class GEO_ACTION_TYPE {
    ENTER, LEAVE, ENTER_AND_LEAVE
}

enum class MEDIA_TYPE {
    IMAGE, VIDEO, AUDIO
}