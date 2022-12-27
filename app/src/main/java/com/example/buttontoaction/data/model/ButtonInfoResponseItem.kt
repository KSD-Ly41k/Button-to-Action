package com.example.buttontoaction.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ButtonInfoResponseItem(
    @SerialName("cool_down") val coolDown: Int?,
    @SerialName("enabled") val enabled: Boolean?,
    @SerialName("priority") val priority: Int?,
    @SerialName("type") val type: String?,
    @SerialName("valid_days") val validDays: List<Int?>?
)