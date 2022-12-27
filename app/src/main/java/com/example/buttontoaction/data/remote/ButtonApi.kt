package com.example.buttontoaction.data.remote

import com.example.buttontoaction.helpers.ButtonConstants.BUTTON_URL
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ButtonApi {
    @GET
    fun getButtonInfo(@Url url: String = BUTTON_URL): Response<Unit>
}
