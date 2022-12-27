package com.example.buttontoaction.di

import com.example.buttontoaction.data.remote.ButtonApi
import com.example.buttontoaction.helpers.ButtonConstants.CONTENT_TYPE_APPLICATION_JSON
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@ExperimentalSerializationApi
class RemoteModule {

    @[Singleton Provides]
    fun getJson(): Json {
        return Json {
            isLenient = true
            encodeDefaults = true
            ignoreUnknownKeys = true
            allowSpecialFloatingPointValues = true
            useArrayPolymorphism = true
        }
    }

    @[Singleton Provides]
    fun getRetrofitInstance(okHttpClient: OkHttpClient, json: Json): Retrofit {
        val contentType = CONTENT_TYPE_APPLICATION_JSON.toMediaType()
        return Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(json.asConverterFactory(contentType))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }

    @[Singleton Provides]
    fun provideOkhttpClient(): OkHttpClient {
        return OkHttpClient.Builder().apply {
            addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })
            connectTimeout(20, TimeUnit.SECONDS)
            readTimeout(20, TimeUnit.SECONDS)
        }.build()
    }

    @ExperimentalSerializationApi
    fun getButtonApi(retrofit: Retrofit): ButtonApi = retrofit.create(ButtonApi::class.java)
}
