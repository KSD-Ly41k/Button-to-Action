package com.example.buttontoaction.domain

import com.example.buttontoaction.presintation.model.ButtonInfoItemModel
import kotlinx.coroutines.flow.Flow

interface ButtonInteractor {
    fun getButtonInfo(): Flow<List<ButtonInfoItemModel>>
}
