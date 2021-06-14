package ru.kipdev.domain.model

data class Task (
    val id: Int,
    val name: String,
    val timeTrigger: TimeTrigger?,
    val geoTriggers: List<GeoTrigger>?,
    val placeTriggers: List<PlaceTrigger>?,
    val declineConditions: List<DeclineCondition>?,
    val declineReiteration: DeclineReiteration?,
    val dismissReiteration: DismissReiteration?
)