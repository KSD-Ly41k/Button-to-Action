package com.example.buttontoaction.data.remote

import com.example.buttontoaction.data.model.ButtonInfoResponseItem
import com.example.buttontoaction.helpers.ButtonConstants.BUTTON_URL
import retrofit2.http.GET
import retrofit2.http.Url

interface ButtonApi {
    @GET
    suspend fun getButtonInfo(@Url url: String = BUTTON_URL): List<ButtonInfoResponseItem>
}
