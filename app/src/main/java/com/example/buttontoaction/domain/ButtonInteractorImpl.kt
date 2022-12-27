package com.example.buttontoaction.domain

import com.example.buttontoaction.domain.mapper.toButtonInfoItemModel
import com.example.buttontoaction.presintation.model.ButtonInfoItemModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ButtonInteractorImpl(
    private val repo: ButtonRepo
) : ButtonInteractor {
    override fun getButtonInfo(): Flow<List<ButtonInfoItemModel>> {
        return flow { emit(repo.getButtonInfo().map { it.toButtonInfoItemModel() }) }
    }
}