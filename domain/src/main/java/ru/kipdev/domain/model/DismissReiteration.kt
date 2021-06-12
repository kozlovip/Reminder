package ru.kipdev.domain.model

import ru.kipdev.domain.utils.DURATION_TYPE

data class DismissReiteration (
    val interval: Int = 5,
    var intervalType: DURATION_TYPE = DURATION_TYPE.MINUTES
)