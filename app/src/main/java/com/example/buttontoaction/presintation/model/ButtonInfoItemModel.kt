package com.example.buttontoaction.presintation.model

import com.example.buttontoaction.domain.model.ButtonType

data class ButtonInfoItemModel(
    val coolDown: Long,
    val enabled: Boolean,
    val priority: Int,
    val type: ButtonType,
    val validDays: List<Int>
)
