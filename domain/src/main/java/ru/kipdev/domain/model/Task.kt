package ru.kipdev.domain.model

data class Task (
    val id: String,
    val name: String,
    val timeTrigger: TimeTrigger,
    val geoTriggers: List<GeoTrigger>,
    val declineConditions: List<DeclineCondition>,
    val declineRepeation: DeclineRepeation,
    val dismissRepeation: DismissRepeation
)