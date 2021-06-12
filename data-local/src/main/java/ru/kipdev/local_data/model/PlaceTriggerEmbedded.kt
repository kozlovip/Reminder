package ru.kipdev.local_data.model

import androidx.room.Embedded
import androidx.room.Relation

data class PlaceTriggerEmbedded (
    @Embedded
    val placeTrigger: PlaceTriggerEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "place_id"
    )
    val places: PlaceEntity
)