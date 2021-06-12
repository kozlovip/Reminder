package ru.kipdev.domain.model

import ru.kipdev.domain.utils.GEO_ACTION_TYPE
import ru.kipdev.domain.utils.MEDIA_TYPE

open class DeclineCondition {
    val description: String = ""

    data class GeoCondition(
        val latitude: Double,
        val longitude: Double,
        val radius: Double,
        val actionType: GEO_ACTION_TYPE
    ) : DeclineCondition()

    data class PassphraseCondition(
        val passphrase: String
    ) : ConditionWithAttempts()

    data class CaptchaCondition(
        val passphrase: String
    ) : ConditionWithAttempts()

    data class EquationCondition(
        val passphrase: String
    ) : ConditionWithAttempts()

    data class MediaCondition(
        val type: MEDIA_TYPE
    ) : ConditionWithAttempts()

    open class ConditionWithAttempts : DeclineCondition(){
        val attempts: Int = 0
    }
}