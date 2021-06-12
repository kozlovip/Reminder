package ru.kipdev.domain.model

import ru.kipdev.domain.utils.GEO_ACTION_TYPE

data class GeoTrigger (
    val latitude: Double,
    val longitude: Double,
    val radius: Double,
    val actionType: GEO_ACTION_TYPE
)