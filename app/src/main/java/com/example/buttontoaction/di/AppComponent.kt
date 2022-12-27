package com.example.buttontoaction.di

import com.example.buttontoaction.presintation.screen.MainActivity
import dagger.Component
import kotlinx.serialization.ExperimentalSerializationApi
import javax.inject.Singleton

@OptIn(ExperimentalSerializationApi::class)
@Component(
    modules = [
        RemoteModule::class,
        RepoModule::class,
        InteractorModule::class,
        ViewModelModule::class
    ]
)
@Singleton
interface AppComponent {
    fun inject(activity: MainActivity)
}
