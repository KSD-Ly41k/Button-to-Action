package com.example.buttontoaction.domain.model

data class ButtonInfoItem(
    val coolDown: Long,
    val enabled: Boolean,
    val priority: Int,
    val type: ButtonType,
    val validDays: List<Int>
)
