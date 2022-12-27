package com.example.buttontoaction.di

import com.example.buttontoaction.domain.ButtonInteractor
import com.example.buttontoaction.domain.ButtonInteractorImpl
import com.example.buttontoaction.domain.ButtonRepo
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class InteractorModule {

    @[Singleton Provides]
    fun provideButtonInteractor(repo: ButtonRepo): ButtonInteractor = ButtonInteractorImpl(repo)
}