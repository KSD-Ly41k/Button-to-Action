package com.example.buttontoaction.di

import dagger.Component
import kotlinx.serialization.ExperimentalSerializationApi

@OptIn(ExperimentalSerializationApi::class)
@Component(
    modules = [
        RemoteModule::class,
        RepoModule::class
    ]
)
interface AppComponent
