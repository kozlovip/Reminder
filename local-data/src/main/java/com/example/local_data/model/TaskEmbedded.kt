package com.example.local_data.model

import androidx.room.Embedded
import androidx.room.Relation

data class TaskEmbedded (
    @Embedded val task: TaskEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "task_id"
    )
    val timeTriggers: TimeTriggerEntity?,
    @Relation(
        parentColumn = "id",
        entityColumn = "task_id"
    )
    val geoTriggers: List<GeoTriggerEntity>,
    @Relation(
        parentColumn = "id",
        entityColumn = "task_id",
        entity = PlaceTriggerEntity::class
    )
    val placeTriggers: List<PlaceTriggerEmbedded>,
    @Relation(
        parentColumn = "id",
        entityColumn = "task_id"
    )
    val declineConditions: List<DeclineConditionEntity>,
    @Relation(
        parentColumn = "id",
        entityColumn = "task_id"
    )
    val declineRepeations: DeclineRepeationEntity?,
    @Relation(
        parentColumn = "id",
        entityColumn = "task_id"
    )
    val dismissRepeations: DismissRepeationEntity?
)