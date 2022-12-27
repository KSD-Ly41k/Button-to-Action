package com.example.buttontoaction.data.mapper

import com.example.buttontoaction.data.model.ButtonInfoResponseItem
import com.example.buttontoaction.domain.model.ButtonInfoItem
import com.example.buttontoaction.domain.model.ButtonType
import com.example.buttontoaction.domain.model.ButtonType.*

fun ButtonInfoResponseItem.toButtonInfoItem(): ButtonInfoItem {
    return ButtonInfoItem(
        coolDown = this.coolDown ?: 0L,
        enabled = this.enabled == true,
        priority = this.priority ?: 0,
        type = getButtonType(this.type),
        validDays = this.validDays?.filterNotNull().orEmpty()
    )
}

private fun getButtonType(type: String?): ButtonType {
    return when (type?.uppercase()) {
        ANIMATION.name -> ANIMATION
        CALL.name -> CALL
        TOAST.name -> TOAST
        NOTIFICATION.name -> NOTIFICATION
        else -> throw Throwable(IllegalArgumentException("Unknown type"))
    }
}

