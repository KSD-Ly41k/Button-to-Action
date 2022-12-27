package com.example.buttontoaction.domain.mapper

import com.example.buttontoaction.domain.model.ButtonInfoItem
import com.example.buttontoaction.presintation.model.ButtonInfoItemModel

fun ButtonInfoItem.toButtonInfoItemModel(): ButtonInfoItemModel {
    return ButtonInfoItemModel(
        coolDown = coolDown,
        enabled = enabled,
        priority = priority,
        type = type,
        validDays = validDays
    )
}

fun List<ButtonInfoItemModel>.totmtp(){

}
