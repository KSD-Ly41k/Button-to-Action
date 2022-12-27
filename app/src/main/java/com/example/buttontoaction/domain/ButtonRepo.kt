package com.example.buttontoaction.domain

import com.example.buttontoaction.domain.model.ButtonInfoItem

interface ButtonRepo {
    suspend fun getButtonInfo(): List<ButtonInfoItem>
}
