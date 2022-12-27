package com.example.buttontoaction.data.repo

import com.example.buttontoaction.data.mapper.toButtonInfoItem
import com.example.buttontoaction.data.remote.ButtonApi
import com.example.buttontoaction.domain.ButtonRepo
import com.example.buttontoaction.domain.model.ButtonInfoItem

class ButtonRepoImpl(
    private val api: ButtonApi
) : ButtonRepo {
    override suspend fun getButtonInfo(): List<ButtonInfoItem> = api.getButtonInfo().map { it.toButtonInfoItem() }
}
