package ru.kipdev.local_data.model

import androidx.room.Embedded
import androidx.room.Relation

data class TaskEntityEmbedded (
    @Embedded val task: TaskEntity,

    @Relation( parentColumn = "id", entityColumn = "task_id" )
    val timeTriggers: TimeTriggerEntity?,

    @Relation( parentColumn = "id", entityColumn = "task_id" )
    val geoTriggers: List<GeoTriggerEntity>,

    @Relation( parentColumn = "id", entityColumn = "task_id", entity = PlaceTriggerEntity::class )
    val placeTriggers: List<PlaceTriggerEmbedded>,

    @Relation( parentColumn = "id", entityColumn = "task_id" )
    val declineConditions: List<DeclineConditionEntity>,

    @Relation( parentColumn = "id", entityColumn = "task_id" )
    val declineRepeations: DeclineReiterationsEntity?,

    @Relation( parentColumn = "id", entityColumn = "task_id" )
    val dismissRepeations: DismissReiterationEntity?
)